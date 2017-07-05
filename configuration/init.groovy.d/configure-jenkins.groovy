#!/usr/bin/env groovy
import jenkins.model.*
import com.smartcodeltd.jenkinsci.plugins.buildmonitor.BuildMonitorView

java.util.logging.Logger.getLogger("LABS").info( 'running configure-jenkins.groovy' )

// delete default OpenShift job
Jenkins.instance.items.findAll{ job -> job.name == 'OpenShift Sample'}.each{ job -> job.delete() }

// create a default build monitor view that includes all jobs
// https://wiki.jenkins-ci.org/display/JENKINS/Build+Monitor+Plugin
if ( Jenkins.instance.views.findAll{ view -> view instanceof com.smartcodeltd.jenkinsci.plugins.buildmonitor.BuildMonitorView }.size == 0){
  view = new BuildMonitorView('Build Monitor','Build Monitor')
  view.setIncludeRegex('.*')
  Jenkins.instance.addView(view)
}

// support custom CSS for htmlreports
// https://stackoverflow.com/questions/35783964/jenkins-html-publisher-plugin-no-css-is-displayed-when-report-is-viewed-in-j
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")

// This is a helper to delete views in the Jenkins script console if needed
// Jenkins.instance.views.findAll{ view -> view instanceof com.smartcodeltd.jenkinsci.plugins.buildmonitor.BuildMonitorView }.each{ view -> Jenkins.instance.deleteView( view ) }