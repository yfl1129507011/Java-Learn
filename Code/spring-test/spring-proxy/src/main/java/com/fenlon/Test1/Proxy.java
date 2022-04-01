package com.fenlon.Test1;

public class Proxy {

    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        seeHouse();
        signContract();
        host.rent();
    }

    private void seeHouse() {
        System.out.println("看房");
    }

    private void signContract() {
        System.out.println("签合同");
    }
}
