package com.b3ds.fhir.metadata.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b3ds.fhir.metadata.dao.AbstractDao;
import com.b3ds.fhir.metadata.dao.MetaDataImpl;
import com.b3ds.fhir.metadata.dao.MetaDataInterface;
import com.b3ds.fhir.metadata.models.MetaData;

@Service("metaDataServiceInterface")
@Transactional
public class MetaDataServiceImpl implements MetaDataServiceInterface{

	@Autowired
	private MetaDataInterface dao;
	
	@Override
	public void saveMetaData(MetaData metadata) {
        dao.saveMetadata(metadata);
    }	
		
	}

	
		
	



	
	
	


