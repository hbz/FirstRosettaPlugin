/**
 * 
 */
package de.nrw.hbz.rosetta.plugin.migrate.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
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
	
	private ClientImpl cImpl = new ClientImpl();

	Properties prop = new Properties();
	private ParameterType param = PdfAPilotParameters.createParamType(prop);

	/**
	 * Method to read Parameters into Plugin
	 * @param initParams
	 */
	public void initParams(Map<String, String> initParams){
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
		initParams.get(COMPLIANCY_LEVEL);
		initParams.get(RETURN_ONLY_VALID_PDFA);
		initParams.get(REPORT_FORMAT);
	}
	
	public void migrateStream(){
		
		ConvertFromStreamResponse response = null; 

		/** Prepare an request with an Stream Resource **/
		ConvertFromStream convStream = new ConvertFromStream();
		convStream.setConverterParameters(getParams());
		
		InputStream is = getClass().getResourceAsStream("/simple_test.pdf") ;
		BufferedInputStream bis = new BufferedInputStream(is);
		ByteArrayOutputStream bat = new ByteArrayOutputStream();
		
		int i = 0;
		try {
			while((i = bis.read()) != -1){
				bat.write(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		byte[] bStream = bat.toByteArray();
		// parse stream into Base64 String 
		String stream64 = null;
		try {
			byte[] bStream64 = Base64.encodeBase64(bStream);
			stream64 = new String(bStream64, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			log.error(e1);
		}
		convStream.setByteStream(stream64);

		/** Call the client with the previously generated request **/
		try{
			response = cImpl.convertFromStream(convStream);
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
		System.out.println("Ergebnis Stream: " + response.getResponseDocumentStream());
		
	}

	public ParameterType getParams(){
		return param;
	}
	
}

/**
#Callas pdfaPilot Configuration File
#Thu Jul 25 07:23:01 CEST 2013
analyseOnly=false
htmlNoDetails=false
htmlOpenResult=true
htmlNoIcons=false
xmlReport=false
reportTrigger=ALWAYS
htmlReport=true
compliancyLevel=2b
createEpub=false
quickProcessing=true
forceConversionReconvert=false
forceConversionPagesToImages=false
forceConversionDocToImages=false
mhtReport=false
returnOnlyValidPdfA=true
reportLang=DE
**/