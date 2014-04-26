#
# Cookbook Name:: zookeeper
# Recipe:: default
#
# Copyright 2014, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#

service "iptables" do
	action :stop
end

package node["java"]["version"] do
	action :install
end

remote_file "/etc/yum.repos.d/zookeeper.repo" do
  source node["zookeeper"]["yum"]["repo"]
  not_if { ::File.exists?("/etc/yum.repos.d/zookeeper.repo") }
end

package "zookeeper" do
	action :install
end

execute "start_zookeeper" do
    command "sudo #{node["zookeeper"]["bin"]}/zkServer.sh start #{node["zookeeper"]["config"]}"
end
