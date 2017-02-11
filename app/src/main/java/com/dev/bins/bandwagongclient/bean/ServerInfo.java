package com.dev.bins.bandwagongclient.bean;

import java.util.Arrays;

/**
 * Created by bin on 11/02/2017.
 */

public class ServerInfo {

//    hostname: "localhost.localdomain",
//    node_ip: "45.78.0.198",
//    node_alias: "v425",
//    node_location: "US, California",
//    location_ipv6_ready: true,
//    plan: "wagon10g512m1t-ca",
//    plan_monthly_data: 1073741824000,
//    plan_disk: 10737418240,
//    plan_ram: 536870912,
//    plan_swap: 67108864,
//    plan_max_ipv6s: 3,
//    os: "ubuntu-16.04-x86_64",
//    email: "bin6160@126.com",
//    data_counter: 403242900,
//    data_next_reset: 1488949200,
//    ip_addresses: [
//            "45.78.36.26"
//            ],
//    rdns_api_available: true,
//    ptr: {
//        45.78.36.26: null
//    },
//    suspended: false,
//    error: 0


    private String hostname;
    private String node_ip;
    private String node_alias;
    private String node_location;
    private boolean location_ipv6_ready;
    private String plan;
    private long plan_monthly_data;
    private long plan_disk;
    private int plan_ram;
    private int plan_swap;
    private int plan_max_ipv6s;
    private String os;
    private String email;
    private int data_counter;
    private int data_next_reset;
    private String[] ip_addresses;
    private boolean rdns_api_available;
    //    ptr: {
//  private       45.78.36.26: null
//  private   },
    private boolean suspended;
    private int error;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getNode_ip() {
        return node_ip;
    }

    public void setNode_ip(String node_ip) {
        this.node_ip = node_ip;
    }

    public String getNode_alias() {
        return node_alias;
    }

    public void setNode_alias(String node_alias) {
        this.node_alias = node_alias;
    }

    public String getNode_location() {
        return node_location;
    }

    public void setNode_location(String node_location) {
        this.node_location = node_location;
    }

    public boolean isLocation_ipv6_ready() {
        return location_ipv6_ready;
    }

    public void setLocation_ipv6_ready(boolean location_ipv6_ready) {
        this.location_ipv6_ready = location_ipv6_ready;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public long getPlan_monthly_data() {
        return plan_monthly_data;
    }

    public void setPlan_monthly_data(long plan_monthly_data) {
        this.plan_monthly_data = plan_monthly_data;
    }

    public long getPlan_disk() {
        return plan_disk;
    }

    public void setPlan_disk(long plan_disk) {
        this.plan_disk = plan_disk;
    }

    public int getPlan_ram() {
        return plan_ram;
    }

    public void setPlan_ram(int plan_ram) {
        this.plan_ram = plan_ram;
    }

    public int getPlan_swap() {
        return plan_swap;
    }

    public void setPlan_swap(int plan_swap) {
        this.plan_swap = plan_swap;
    }

    public int getPlan_max_ipv6s() {
        return plan_max_ipv6s;
    }

    public void setPlan_max_ipv6s(int plan_max_ipv6s) {
        this.plan_max_ipv6s = plan_max_ipv6s;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getData_counter() {
        return data_counter;
    }

    public void setData_counter(int data_counter) {
        this.data_counter = data_counter;
    }

    public int getData_next_reset() {
        return data_next_reset;
    }

    public void setData_next_reset(int data_next_reset) {
        this.data_next_reset = data_next_reset;
    }

    public String[] getIp_addresses() {
        return ip_addresses;
    }

    public void setIp_addresses(String[] ip_addresses) {
        this.ip_addresses = ip_addresses;
    }

    public boolean isRdns_api_available() {
        return rdns_api_available;
    }

    public void setRdns_api_available(boolean rdns_api_available) {
        this.rdns_api_available = rdns_api_available;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "hostname='" + hostname + '\'' +
                ", node_ip='" + node_ip + '\'' +
                ", node_alias='" + node_alias + '\'' +
                ", node_location='" + node_location + '\'' +
                ", location_ipv6_ready=" + location_ipv6_ready +
                ", plan='" + plan + '\'' +
                ", plan_monthly_data=" + plan_monthly_data +
                ", plan_disk=" + plan_disk +
                ", plan_ram=" + plan_ram +
                ", plan_swap=" + plan_swap +
                ", plan_max_ipv6s=" + plan_max_ipv6s +
                ", os='" + os + '\'' +
                ", email='" + email + '\'' +
                ", data_counter=" + data_counter +
                ", data_next_reset=" + data_next_reset +
                ", ip_addresses=" + Arrays.toString(ip_addresses) +
                ", rdns_api_available=" + rdns_api_available +
                ", suspended=" + suspended +
                ", error=" + error +
                '}';
    }
}
