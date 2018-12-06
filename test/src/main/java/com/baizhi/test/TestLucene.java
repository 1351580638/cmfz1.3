package com.baizhi.test;



import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;

import org.junit.jupiter.api.Test;



import java.io.IOException;

public class TestLucene {
    @Test
    public void testCreateIndex(){
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        for(int i=0;i<10;i++){
            Document document = new Document();
            document.add(new StringField("id",String.valueOf(i), Field.Store.YES));
            document.add(new StringField("title","背影", Field.Store.YES));
            document.add(new StringField("author","朱自清", Field.Store.YES));
            document.add(new StringField("date","2018-12-4", Field.Store.YES));
            document.add(new TextField("content","你在這別動别动", Field.Store.YES));
            try {
                indexWriter.addDocument(document);
            }catch(Exception e){
                LuceneUtil.rollback(indexWriter);
                e.printStackTrace();
            }
        }
        LuceneUtil.commit(indexWriter);
    }
    @Test
    public void testSearchIndex(){
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
        Query query = new TermQuery(new Term("title", "背影"));
        try {
            TopDocs topDocs = indexSearcher.search(query, 100);
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for (int i = 0; i < scoreDocs.length; i++) {
                ScoreDoc scoreDoc = scoreDocs[i];
                float score = scoreDoc.score;
                int doc = scoreDoc.doc;
                Document document = indexSearcher.doc(doc);
                System.out.println("this is score " + score);
                System.out.println("this is id " + document.get("id"));
                System.out.println("this is title " + document.get("title"));
                System.out.println("this is author " + document.get("author"));
                System.out.println("this is content " + document.get("content"));
                System.out.println("this is date " + document.get("date"));
                System.out.println("==================");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDelete(){
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        try {
            indexWriter.deleteDocuments(new Term("id","0"));
            LuceneUtil.commit(indexWriter);
        } catch (IOException e) {
            LuceneUtil.rollback(indexWriter);
            e.printStackTrace();
        }
    }
    @Test
    public void testUpdate(){
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        Document document = new Document();
        document.add(new StringField("id", "1", Field.Store.YES));
        document.add(new StringField("title", "我爱中国", Field.Store.YES));
        document.add(new StringField("author", "htf", Field.Store.YES));
        document.add(new StringField("date", "2018-12-4", Field.Store.YES));
        document.add(new TextField("content", "我是中国人+1+1+1+1+1", Field.Store.YES));
        try {
            indexWriter.updateDocument(new Term("id","2"),document);
            LuceneUtil.commit(indexWriter);
        } catch (IOException e) {
            LuceneUtil.rollback(indexWriter);
            e.printStackTrace();
        }


    }
}
