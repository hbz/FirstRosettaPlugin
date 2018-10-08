

/**
 * PdfAConverter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package de.nrw.hbz.pdfaconverter.services;

    /*
     *  PdfAConverter java interface
     */

    public interface PdfAConverter {
          

        /**
          * Auto generated method signature
          * Operation converts a PDF supplied by an URL to PDF/A. Operation returns 2 URLs: one for the PDF/A and one for the Report.
                    * @param convertFromUrl0
                
             * @throws de.nrw.hbz.pdfaconverter.services.ConvertFromUrl_faultMsg : 
         */

         
                     public de.nrw.hbz.pdfaconverter.types.ConvertFromUrlResponse convertFromUrl(

                    		 de.nrw.hbz.pdfaconverter.types.ConvertFromUrl convertFromUrl0)
                        throws java.rmi.RemoteException
             
          ,de.nrw.hbz.pdfaconverter.services.ConvertFromUrl_faultMsg;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * Operation converts a PDF supplied by an URL to PDF/A. Operation returns 2 URLs: one for the PDF/A and one for the Report.
                * @param convertFromUrl0
            
          */
        public void startconvertFromUrl(

        		de.nrw.hbz.pdfaconverter.types.ConvertFromUrl convertFromUrl0,

            final de.nrw.hbz.pdfaconverter.services.PdfAConverterCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * Operation uses SwA (Soap with Attachment) for supplying the PDF to the PDF/A Converter. Operation returns an Attachment with the PDF/A and an Attachment with the Record inside
                    * @param convertFromAttachment2
                
             * @throws de.nrw.hbz.pdfaconverter.services.ConvertFromAttachment_faultMsg : 
         */

         
                     public de.nrw.hbz.pdfaconverter.types.ConvertFromAttachmentResponse convertFromAttachment(

                    		 de.nrw.hbz.pdfaconverter.types.ConvertFromAttachment convertFromAttachment2)
                        throws java.rmi.RemoteException
             
          ,de.nrw.hbz.pdfaconverter.services.ConvertFromAttachment_faultMsg;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * Operation uses SwA (Soap with Attachment) for supplying the PDF to the PDF/A Converter. Operation returns an Attachment with the PDF/A and an Attachment with the Record inside
                * @param convertFromAttachment2
            
          */
        public void startconvertFromAttachment(

        		de.nrw.hbz.pdfaconverter.types.ConvertFromAttachment convertFromAttachment2,

            final de.nrw.hbz.pdfaconverter.services.PdfAConverterCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param batchConvert4
                
             * @throws de.nrw.hbz.pdfaconverter.services.BatchConvertFaultException0 : 
         */

         
                     public de.nrw.hbz.pdfaconverter.services.BatchConvertResponse batchConvert(

                        de.nrw.hbz.pdfaconverter.services.BatchConvert batchConvert4)
                        throws java.rmi.RemoteException
             
          ,de.nrw.hbz.pdfaconverter.services.BatchConvertFaultException0;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param batchConvert4
            
          */
        public void startbatchConvert(

            de.nrw.hbz.pdfaconverter.services.BatchConvert batchConvert4,

            final de.nrw.hbz.pdfaconverter.services.PdfAConverterCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * Operation converts a PDF supplied within the SOAP Message as Byte-Stream to PDF/A. Operation returns one Bytestream for the PDF/A and one for the Report associated.
                    * @param convertFromStream6
                
             * @throws de.nrw.hbz.pdfaconverter.services.ConvertFromStream_faultMsg : 
         */

         
                     public de.nrw.hbz.pdfaconverter.types.ConvertFromStreamResponse convertFromStream(

                    		 de.nrw.hbz.pdfaconverter.types.ConvertFromStream convertFromStream6)
                        throws java.rmi.RemoteException
             
          ,de.nrw.hbz.pdfaconverter.services.ConvertFromStream_faultMsg;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * Operation converts a PDF supplied within the SOAP Message as Byte-Stream to PDF/A. Operation returns one Bytestream for the PDF/A and one for the Report associated.
                * @param convertFromStream6
            
          */
        public void startconvertFromStream(

        		de.nrw.hbz.pdfaconverter.types.ConvertFromStream convertFromStream6,

            final de.nrw.hbz.pdfaconverter.services.PdfAConverterCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    