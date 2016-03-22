package com.ustbgao.text.utils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.*;


/**
 * Created by ustbgao on 15-8-27.
 */
public class Indexer {
    private IndexWriter indexWriter;
    public Indexer(String indexDir) throws IOException{
        Directory directory = FSDirectory.open(new File(indexDir));
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_4_9);
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_4_9 , analyzer);
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        indexWriter = new IndexWriter(directory ,indexWriterConfig);

    }
    public static String getContent(File file) throws Exception{
        FileInputStream fis=new FileInputStream(file);
        InputStreamReader isr=new InputStreamReader(fis);
        BufferedReader br=new BufferedReader(isr);
        StringBuffer sb=new StringBuffer();
        String line=br.readLine();
        while(line!=null){
            sb.append(line+"\n");
            line=null;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    public void close()throws IOException{
        indexWriter.close();
    }
    public int index(String dataDir , FileFilter fileFilter) throws Exception{
        File[] files = new File(dataDir).listFiles();
        for(File file : files){
            if(!file.isDirectory() && !file.isHidden() && file.exists() && file.canRead() &&(fileFilter == null || fileFilter.accept(file))){
                indexFile(file);
            }

        }
        System.out.println(indexWriter.numDocs());
        return indexWriter.numDocs();
    }
    private static class TestFileFileter implements FileFilter{
        @Override
        public boolean accept(File pathname) {
            return pathname.getName().toLowerCase().endsWith(".txt");
        }
    }
    public Document getDocument(File f) throws Exception{
        Document document = new Document();
        document.add(new StringField("path" , f.getAbsolutePath() , Field.Store.YES));
        document.add(new StringField("filename" , f.getName(),Field.Store.YES));
        document.add(new Field("contents", getContent(f),Field.Store.YES,Field.Index.ANALYZED));
        return document;

    }
    public void indexFile(File file) throws  Exception{
        System.out.println("Indexing" + file.getCanonicalPath());
        Document document = getDocument(file);
        indexWriter.addDocument(document);
    }
    public static void main(String [] args) throws Exception{
        String indexDir = "e:/index";
        String dataDir = "e:/data";
        long start = System.currentTimeMillis();
        int numIndexed;
        Indexer indexer = new Indexer(indexDir);
        try {
            numIndexed = indexer.index(dataDir , new TestFileFileter());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            indexer.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("索引用时是:" + (end - start));
    }
}

