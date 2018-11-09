package com.b3ds.fhir.metadata.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="metadata")

public class MetaData {
	
	@Column(name="resourceType")
	private String resourceType;
	@Id
	private String pId;
	@Column(name="fhirVersion", unique=true, nullable=false, length=10)
	private String fhirVersion;
	@Column(name="pSource", unique=false, nullable=false, length=30)
	private String pSource;
	
	public MetaData(){}
	
	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getFhirVersion() {
		return fhirVersion;
	}

	public void setFhirVersion(String fhirVersion) {
		this.fhirVersion = fhirVersion;
	}
	public String getpSource() {
		return pSource;
	}

	public void setpSource(String pSource) {
		this.pSource = pSource;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof MetaData))
            return false;
        MetaData other = (MetaData) obj;
        if (pId != other.pId)
            return false;
        return true;
    }

	 @Override
	    public String toString() {
	        return "ID =" + pId + ", FhirVersion=" + fhirVersion + ", pSource="
	                + pSource + ", ResourceType=" + resourceType ;
	    }
	
	
	

}
