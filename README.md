ZooPeeker
=========

ZooPeeker is a simple browser based user interface for [Apache ZooKeeper](http://zookeeper.apache.org/) developed with [DropWizard](http://dropwizard.codahale.com/ "DropWizard").

#### Configuration
The DropWizard configuration file needs to specify the ZooKeeper **host** and **port** to connect to.

The defaults in the `config.yml` are:

    zookeeper:
		host: 192.168.33.10
    	port: 2181


#### Development

* Apache Maven 2.2.1
* Java 7
* Vagrant 1.4.3 (optional)
* Chef 11.10.0 (optional)

After you `compile` and `install` with Maven, you can use `exec:java` to run the application.  Open a web browser to `localhost:8080`.

[Click here to open ZooPeeker in your browser](http://localhost:8080 "ZooPeeker")

##### Developing with Vagrant and Chef
This project includes a `Vagrantfile` with Chef provisioning and a simple cookbook to install ZooKeeper.  The VMs IP Address is defaulted `192.168.33.10`.  The defaults in the ZooPeeker `config.yml` are setup to use the VM.

	$ vagrant up
	$ vagrant provision


#### Running
ZooPeeker can be run with the following command:

    java -jar zoopeeker.jar server config.yaml