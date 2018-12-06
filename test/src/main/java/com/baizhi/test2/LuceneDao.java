package com.baizhi.test2;
import com.baizhi.test.LuceneUtil;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LuceneDao {
    //添加
    public void addIndex(Artical artical){
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        Document doc = getDocFromArt(artical);
        try {
            indexWriter.addDocument(doc);
            LuceneUtil.commit(indexWriter);
        } catch (IOException e) {
            LuceneUtil.rollback(indexWriter);
            e.printStackTrace();
        }

    }

    public Artical  getArtFromDoc(Document document){
        Artical artical = new Artical();
        artical.setId(document.get("id"));
        artical.setDesc(document.get("desc"));
        artical.setImg(document.get("img"));
        artical.setAddress(document.get("address"));
        artical.setPrice(document.get("price"));
        artical.setDate(document.get("date"));
        return artical;


    }


    public Document getDocFromArt(Artical artical){
        Document document = new Document();
        document.add(new StringField("id",artical.getId(), Field.Store.YES));
        document.add(new StringField("price",artical.getPrice(), Field.Store.YES));
        document.add(new StringField("desc",artical.getDesc(), Field.Store.YES));
        document.add(new StringField("img",artical.getImg(), Field.Store.YES));
        document.add(new StringField("status",artical.getStatus(), Field.Store.YES));
        document.add(new StringField("address",artical.getAddress(), Field.Store.YES));
        document.add(new TextField("date",artical.getDate(), Field.Store.YES));
            return document;
    }
    //删除
    public void delete(String id){
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        try {
            indexWriter.deleteDocuments(new Term("id",id));
            LuceneUtil.commit(indexWriter);
        } catch (IOException e) {
            LuceneUtil.rollback(indexWriter);
            e.printStackTrace();
        }
    }
    //查询
    public List<Artical> query(String params){
        List<Artical> articals =new ArrayList<>();
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
        try {
            TopDocs topDocs = indexSearcher.search(new TermQuery(new Term("content", params)), 100);
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;

            for (int i = 0; i < scoreDocs.length; i++) {
                ScoreDoc scoreDoc = scoreDocs[i];
                int doc = scoreDoc.doc;
                Document document = indexSearcher.doc(doc);
                Artical artFromDoc = getArtFromDoc(document);
                articals.add(artFromDoc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return articals;
    }
    //修改
    public void update(Artical artical){
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        Document docFromArt = getDocFromArt(artical);
        try {
            indexWriter.updateDocument(new Term("id",artical.getId()),docFromArt);
            LuceneUtil.commit(indexWriter);
        } catch (IOException e) {
            LuceneUtil.rollback(indexWriter);
            e.printStackTrace();
        }

    }

}
