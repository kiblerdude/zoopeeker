# -*- mode: ruby -*-
# vi: set ft=ruby :

VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

	config.vm.box_url = "http://developer.nrel.gov/downloads/vagrant-boxes/CentOS-6.4-i386-v20130731.box"  
  
	config.vm.define "zoopeeker" do |node|
		node.vm.box = "zoopeeker"
		node.vm.network :private_network, ip: "192.168.33.10"
		node.vm.provider :virtualbox do |vb|
			vb.customize ["modifyvm", :id, "--memory", "1024"]
			vb.customize ["modifyvm", :id, "--cpus", "1"]   
		end 	
		
		node.vm.provision :chef_solo do |chef|
			chef.cookbooks_path = "chef-repo/cookbooks"
			chef.json = {
				"zookeeper" => {
					"yum" => {
						"repo" => "http://public-repo-1.hortonworks.com/HDP-1.2.0/repos/centos6/hdp.repo"
					}
				}
			}
			chef.add_recipe "zookeeper"
		end		
	end	
end