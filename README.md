# openshift-jenkins-s2i-config
Config repo used to build a customized OpenShift Jenkins image using [source to image (S2I)](https://github.com/openshift/source-to-image). The base OpenShift Jenkins S2I can be found at `registry.access.redhat.com/openshift3/jenkins-1-rhel7`.

## Usage
While we could use S2I locally, we always expect this configuration to used with OpenShift, which can be done with the following command: `oc new-app openshift/jenkins~https://github.com/rht-labs/openshift-jenkins-s2i-config.git --name jenkins-master`

## Project Layout
Dictated by [the upstream documentation](https://github.com/openshift/jenkins/blob/master/README.md#installing-using-s2i-build) of the S2I base image.

## Retrieving Plugin Inventory
There is a [groovy helper script](helpers/writePluginFile.groovy) to retrieve this info. If you have [groovy installed](http://groovy-lang.org/download.html), you can run the script in the shell like a normal script bash or bat script. The script doesn't currently support CLI args, so you'll need to modify it directly. it leverages the pluginManager REST API and produces a `plugins.txt` in the working directory which you can move to the root directory if you like it.

## Contributing

See [the guide](https://github.com/rht-labs/api-design/blob/master/CONTRIBUTING.md)

### License
[ASL 2.0](LICENSE)