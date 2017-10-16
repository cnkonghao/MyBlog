package com.blog.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class SensitiveService implements InitializingBean{

	private static final Logger logger = LoggerFactory.getLogger(SensitiveService.class);
	
	@Override
	public void afterPropertiesSet() throws Exception {
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("sensitiveWords.txt");
			InputStreamReader reader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(reader);
			String value="";
			while((value=br.readLine())!=null){
			addWords(value);
			}
		} catch (Exception e) {
			logger.error("载入敏感词文件出错"+e.getMessage());
		}
 	}
	
	 // 字典树
    private class TrieNode {
    	//是否为关键词结尾的结点
        private boolean end = false;
      //前缀树中的一个结点持有一个map，这个map中就是当前结点的子结点
        private Map<Character, TrieNode> subNodes = new HashMap<Character, TrieNode>();
      //得到子节点
        public TrieNode getSubNodes(Character c){
            return subNodes.get(c);
        }
        //增加子节点
        public void setSubNodes(Character c, TrieNode node){
            subNodes.put(c, node);
        }
      //设置为结尾结点
        public void setKeyWordEnd(boolean end){
            this.end = end;
        }
      //判断是否为结尾节点
        public boolean isKeyWordEnd(){
            return end;
        }
    }
    
    private TrieNode rootNode = new TrieNode();

	//判断是否为故意扰乱敏感词的字符
	private boolean isSymbol(Character c){
		int ch = (int)c;
		//东亚文字
		return !CharUtils.isAsciiAlphanumeric(c) && (ch < 0x2e80 || ch > 0x9fff);
	}
	
	 // 向字典树中插入敏感词
    /**
     * 增加关键字的结点
     * 每次从lineTxt中读一个字符,然后查询当前结点下有没有这个字符
     * 如果没有就创建一下，然后当前指针向下移动
     * 如果lineTxt走到最后，说明为结尾结点
     * @param lineTxt
     */
    private void addWords(String lineTxt){
        TrieNode tmp = rootNode;
        for (int i = 0; i < lineTxt.length(); i++){
            Character c = lineTxt.charAt(i);

            if (isSymbol(c))
                continue;

            TrieNode node = tmp.getSubNodes(c);
            if (node == null){
                node = new TrieNode();
                tmp.setSubNodes(c, node);
            }

            tmp = node;

            if (i == lineTxt.length() - 1)
                tmp.setKeyWordEnd(true);
        }
    }
    
    // filter 用来过滤的函数
    public String filter(String line){
        if (StringUtils.isBlank(line))
            return line;

        String replacement = "***";
        StringBuilder sb = new StringBuilder();
        TrieNode tmp = rootNode;
      //begin一直向后移动，代表当前搜索的敏感词的头结点
        int begin = 0;
      //position是当前敏感词的某一个结点，来回移动的那个
        int position = 0;

        while (position < line.length() || begin < line.length()){
            if (position >= line.length()){
                sb.append(line.charAt(begin));
                begin = begin + 1;
                position = begin;
                tmp = rootNode;
                continue;
            }

            Character c = line.charAt(position);
            if (isSymbol(c)){
            	//如果还在rootNode，说明还没进前缀树，
                //这部分奇怪的字符直接加进来就好
                //否则就跳过，只找那些关键字过滤
                if (tmp == rootNode){
                    sb.append(c);
                    begin++;
                }
                position++;
                continue;
            }
            tmp = tmp.getSubNodes(c);
          //当前结点为null，说明不是敏感词
            if (tmp == null){
                sb.append(line.charAt(begin));
                position = begin + 1;
                begin = position;
                tmp = rootNode;
            } else if (tmp.isKeyWordEnd()){
                sb.append(replacement);
                position = position + 1;
                begin = position;
                tmp = rootNode;
            } else{
                position ++;
            }
        }
        return sb.toString();
    }
	
}
