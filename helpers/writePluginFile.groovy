#!/usr/bin/env groovy

// This script doesn't parse cli args right now, you'll need to modify it directly

String user = 'admin'
String password = 'admin'
String apiHost = 'localhost:8080'
// http://stackoverflow.com/questions/9815273/how-to-get-a-list-of-installed-jenkins-plugins-with-name-and-version-pair
String apiResource = 'pluginManager/api/json'
// http://stackoverflow.com/questions/17236710/jenkins-rest-api-using-tree-to-reference-specific-item-in-json-array
String apiQueryString = 'depth=1&tree=plugins[shortName,version]'


def json = new URL(buildUrl(user,password, apiHost, apiResource, apiQueryString)).getText()
def result = new groovy.json.JsonSlurper().parseText( json )
new File('plugins.txt').write buildPluginsString(result)



/*********************
 * Everything below here is a helper function
 *********************/
def buildUrl(String user, String password, String apiHost, String apiResource, String apiQueryString){
	return "http://${user}:${password}@${apiHost}/${apiResource}?${apiQueryString}"
}

def buildPluginsString(def result){
	def sb = new StringBuilder()
	result.plugins.each{ plugin ->
		// check if the dependency was pulled from a private .m2
		// if true, this dependnecy should be added as a binary in the plugins directory
		if (!plugin.version.contains('private')){
			sb.append "${plugin.shortName} ${plugin.version}\n"
		}
	}
	return sb.toString()
}