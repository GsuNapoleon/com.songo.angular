/**
 * 
 */
package com.songo.angular.search;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.index.CompositeReader;
import org.apache.lucene.index.Fields;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.StoredFieldVisitor;
import org.apache.lucene.index.Term;

/**
 * <p>decription:</p>
 * <p>date:2014年9月4日 下午3:52:05</p>
 * @author gsu·napoleon
 */
public class GoogleCompositeReader extends CompositeReader {

	/* (non-Javadoc)
	 * @see org.apache.lucene.index.CompositeReader#getSequentialSubReaders()
	 */
	@Override
	protected List<? extends IndexReader> getSequentialSubReaders() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.lucene.index.IndexReader#getTermVectors(int)
	 */
	@Override
	public Fields getTermVectors(int docID) throws IOException {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.lucene.index.IndexReader#numDocs()
	 */
	@Override
	public int numDocs() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.apache.lucene.index.IndexReader#maxDoc()
	 */
	@Override
	public int maxDoc() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.apache.lucene.index.IndexReader#document(int, org.apache.lucene.index.StoredFieldVisitor)
	 */
	@Override
	public void document(int docID, StoredFieldVisitor visitor)
			throws IOException {

	}

	/* (non-Javadoc)
	 * @see org.apache.lucene.index.IndexReader#doClose()
	 */
	@Override
	protected void doClose() throws IOException {

	}

	/* (non-Javadoc)
	 * @see org.apache.lucene.index.IndexReader#docFreq(org.apache.lucene.index.Term)
	 */
	@Override
	public int docFreq(Term term) throws IOException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.apache.lucene.index.IndexReader#totalTermFreq(org.apache.lucene.index.Term)
	 */
	@Override
	public long totalTermFreq(Term term) throws IOException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.apache.lucene.index.IndexReader#getSumDocFreq(java.lang.String)
	 */
	@Override
	public long getSumDocFreq(String field) throws IOException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.apache.lucene.index.IndexReader#getDocCount(java.lang.String)
	 */
	@Override
	public int getDocCount(String field) throws IOException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.apache.lucene.index.IndexReader#getSumTotalTermFreq(java.lang.String)
	 */
	@Override
	public long getSumTotalTermFreq(String field) throws IOException {
		return 0;
	}

}
