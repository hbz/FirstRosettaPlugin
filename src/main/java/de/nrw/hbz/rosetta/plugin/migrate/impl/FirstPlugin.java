/**
 * 
 */
package de.nrw.hbz.rosetta.plugin.migrate.impl;

import java.util.Map;

/**
 * @author aquast
 *
 */
public class FirstPlugin {

	private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
	private static final String COMPLIANCY_LEVEL = "compliancyLevel";
	private static final String RETURN_ONLY_VALID_PDFA = "returnOnlyValidPdfA";
	private static final String REPORT_FORMAT = "reportFormat";
	
	private static String pluginVersion = null;
	
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