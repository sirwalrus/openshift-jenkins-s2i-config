# Innovation Labs Jenkins Master Configuration
Config repo used to build a customized OpenShift Jenkins 2 image using [source to image (S2I)](https://github.com/openshift/source-to-image). The base OpenShift Jenkins S2I can be found at `registry.access.redhat.com/openshift3/jenkins-2-rhel7`.

## Usage
This Jenkins configuration is for a Jenkins 2.x master, using a master / agent architecture. Agents are provided as pods in k8s via the [k8s Jenkins plugin](https://github.com/jenkinsci/kubernetes-plugin) configuration in the OpenShift Jenkins base S2I image. Thus, this config doesn't define any build tools or the like, as they are the responsibility of agents.

This configuration should be used in combination with the out of the box OpenShift Jenkins templates, as demonstrated in [this example](https://github.com/sherl0cks/examples/tree/jenkins-ocp-templates/jenkins-ocp-templates).

## Project Layout
Dictated by [OpenShift Jenkins S2I image](https://github.com/openshift/jenkins/blob/master/README.md#installing-using-s2i-build)

## Retrieving Plugin Inventory
See [the other README](helpers/README.MD)

## Contributing

See [the guide](https://github.com/rht-labs/api-design/blob/master/CONTRIBUTING.md)

### License
[ASL 2.0](LICENSE)
