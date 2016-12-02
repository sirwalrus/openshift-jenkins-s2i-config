/***
We are using this configuration because openshift/jenkins s2i does not currently support hidden folders like .m2 
https://github.com/openshift/jenkins/issues/212
*/


File mvnDir = new File("/var/lib/jenkins/.m2")
boolean dirMade = mvnDir.mkdir()
File settings = new File("/var/lib/jenkins/settings.xml");  
File newSettings = new File("/var/lib/jenkins/.m2/settings.xml")
newSettings << settings.text