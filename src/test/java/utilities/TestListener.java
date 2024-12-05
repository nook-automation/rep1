package utilities;


	
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

import functionalLibrary.TestBase;

import javax.mail.*;
	import javax.mail.internet.*;
	import java.io.File;
	import java.util.Properties;


	public class TestListener extends TestBase implements ITestListener{
		
		public static String  reportPath=System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "emailable-report.html";
		
	    @Override
	    public void onTestStart(ITestResult result) { }

	    @Override
	    public void onTestSuccess(ITestResult result) { }

	    @Override
	    public void onTestFailure(ITestResult result) { }

	    @Override
	    public void onTestSkipped(ITestResult result) { }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }

	    @Override
	    public void onStart(ITestContext context) { }

	    @Override
	    public void onFinish(ITestContext context) {
	        sendEmailWithAttachment(reportPath);
	    }

	    // Method to send email with the test report attached
	       public static void sendEmailWithAttachment(String reportPath) {
	        // Set up the email properties and SMTP server details
	        String host = "smtp-mail.outlook.com";
	        final String user = "bjanakiraman@bn.com";  // Your email address
	        final String password = "Autumn@Nov2024!";  // Your email password
	        String to = "kvengattan@bn.com, ssidharthan@bn.com,aelango@bn.com";  // Recipients' email addresses
	        String subject = "TestNG Report For Ios BA Test Run";
	        String body = "Please find the attached TestNG report.\n\n"
	                + "Hi all,\n\n"
	                + "Test Information:\n\n"
	                + "Test Version: 6.7.2.6\n"
	                + "Test Device: Iphone 13\"\n"
	                + "Serial Number: DK7HGJ4VX4\n"
	                + "Test Account: autacc_001@bn.com\n\n";

	        Properties properties = System.getProperties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.auth", "true");

	        Session session = Session.getDefaultInstance(properties, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(user, password);
	            }
	        });

	        try {
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(user));
	            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	            message.setSubject(subject);

	            // Creating the body of the email
	            MimeBodyPart textPart = new MimeBodyPart();
	            textPart.setText(body);

	            // Attaching the report file
	            MimeBodyPart attachmentPart = new MimeBodyPart();
	            File reportFile = new File(reportPath);
	            attachmentPart.attachFile(reportFile);

	            // Combine the body and attachment parts
	            Multipart multipart = new MimeMultipart();
	            multipart.addBodyPart(textPart);
	            multipart.addBodyPart(attachmentPart);

	            message.setContent(multipart);

	            // Send the email
	            Transport.send(message);
	            System.out.println("TestNG report sent successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



