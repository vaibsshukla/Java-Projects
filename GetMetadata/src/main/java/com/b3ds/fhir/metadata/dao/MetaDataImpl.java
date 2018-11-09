package com.b3ds.fhir.metadata.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.b3ds.fhir.metadata.models.MetaData;

@Repository("metaDataInterface")
public class MetaDataImpl  extends AbstractDao implements MetaDataInterface{
	
	@Override
	public void saveMetadata(MetaData metadata) {
		// TODO Auto-generated method stub
		persist(metadata);
		
	}
	
	

}
