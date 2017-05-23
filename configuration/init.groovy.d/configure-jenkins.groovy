#!/usr/bin/env groovy
import jenkins.model.*
import com.smartcodeltd.jenkinsci.plugins.buildmonitor.BuildMonitorView

java.util.logging.Logger.getLogger("LABS").info( 'running configure-jenkins.groovy' )

// delete default OpenShift job
Jenkins.instance.items.findAll{ job -> job.name == 'OpenShift Sample'}.each{ job -> job.delete() }

// create a default build monitor view that includes all jobs
// https://wiki.jenkins-ci.org/display/JENKINS/Build+Monitor+Plugin
view = new BuildMonitorView('monitor','Build Monitor')
view.setIncludeRegex('.*')
Jenkins.instance.addView(view)