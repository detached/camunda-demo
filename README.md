camunda-demo
============

Camunda BPM demo for DevCamp

This process is using camunda-cdi for bean and processVariable injection.

Get this up and running on Jboss 7:

* edit the standalone.xml:


        <process-engine name="default" default="true">
          ...
          <configuration>
            org.camunda.bpm.engine.cdi.CdiJtaProcessEngineConfiguration
          </configuration>
          ...
        </process-engine>


* Add the _camunda-engine-cdi-7.0.0-Final.jar_ as Jboss module
* In the _module.xml_ of  _org.camunda.bpm.jboss.camunda-jboss-subsystem_ add a dependency to the cdi module
* Restart the server
