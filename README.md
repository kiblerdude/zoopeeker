ZooPeeker
=========

A Web User Interface for Apache ZooKeeper.

#### About
ZooPeeker is a simple user interface for Apache ZooKeeper developed with DropWizard ([http://dropwizard.codahale.com/](http://dropwizard.codahale.com/ "DropWizard")).

#### Running
ZooPeeker can be run with the following command:

    java -jar zoopeeker.jar server config.yaml

#### Configuration
The DropWizard configuration file needs to specify the ZooKeeper **host** and **port** to connect to.

The defaults in the `config.yml` are:

    zookeeper:
		host: 192.168.33.10
    	port: 2181


#### Development

* Apache Maven 2.2.1
* Java 7

After you `compile` and `install` with Maven, you can use `exec:java` to run the application.

Open `localhost:8080` in a browser.
