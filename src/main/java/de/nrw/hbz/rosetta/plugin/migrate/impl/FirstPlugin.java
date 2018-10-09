/**
 * 
 */
package de.nrw.hbz.rosetta.plugin.migrate.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import de.nrw.hbz.pdfaconverter.util.PdfAPilotParameters;
import de.nrw.hbz.pdfaconverter.types.CompliancyLevelType;
import de.nrw.hbz.pdfaconverter.types.ConvertFromStream;
import de.nrw.hbz.pdfaconverter.types.ConvertFromStreamResponse;
import de.nrw.hbz.pdfaconverter.types.HtmlOptionType;
import de.nrw.hbz.pdfaconverter.types.ParameterType;
import de.nrw.hbz.pdfaconverter.types.ReportFormatType;
import de.nrw.hbz.pdfaconverter.types.ReportLangType;
import de.nrw.hbz.pdfaconverter.types.ReportTriggerType;
import de.nrw.hbz.rosetta.plugin.migrate.client.impl.ClientImpl;

import com.exlibris.core.sdk.storage.containers.StoredEntityMetaData;

/**
 * @author aquast
 *
 */
public class FirstPlugin {
	
	// Initiate Logger for ClientImpl
	private static Logger log = Logger.getLogger(FirstPlugin.class);

	private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
	private static final String COMPLIANCY_LEVEL = "compliancyLevel";
	private static final String RETURN_ONLY_VALID_PDFA = "returnOnlyValidPdfA";
	private static final String REPORT_FORMAT = "reportFormat";
	private static String pluginVersion = null;
	
	private Properties prop =  PdfAPilotParameters.getDefaultProperties();
	private StoredEntityMetaData semd = new StoredEntityMetaData();

	/**
	 * Method to read Parameters into Plugin
	 * @param initParams
	 */
	public void initParams(Map<String, String> initParams){
		pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
		initParams.get(COMPLIANCY_LEVEL);
		initParams.get(RETURN_ONLY_VALID_PDFA);
		initParams.get(REPORT_FORMAT);

		prop.setProperty(COMPLIANCY_LEVEL,initParams.get(COMPLIANCY_LEVEL));

	
	}
	
	public void migrateStream(){
		
		ConvertFromStreamResponse response = null; 
		
		File fPath = new File(semd.getCurrentFilePath());

		ClientImpl cImpl = new ClientImpl();
		/** Prepare an request with an Stream Resource **/
		ConvertFromStream convStream = new ConvertFromStream();
		convStream.setConverterParameters(getParams());
		
		convStream.setByteStream(de.nrw.hbz.pdfaconverter.util.FileUtil.loadFileIntoStream(fPath).toString());

		/** Call the client with the previously generated request **/
		try{
			response = cImpl.convertFromStream(convStream);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		log.info("Ergebnis Stream: " + response.getResponseDocumentStream());
		
	}

	public ParameterType getParams(){
		ParameterType param = PdfAPilotParameters.createParamType(prop);
		return param;
	}
	
}
