package com.bubsstuff.webbrowser;

public class HistoryList {
    private ListNode<String> head = new ListNode<>();
    private ListNode<String> currentWebSite;

    public HistoryList(String currentSite) {
        this.currentWebSite = new ListNode<>(currentSite);
        this.head.nextSite = this.currentWebSite;
        this.currentWebSite.previousSite = this.head;

    }

    public void addSite (String newSite) {
        ListNode<String> newWebSite = new ListNode<>(newSite);

        this.currentWebSite.nextSite = newWebSite;
        newWebSite.nextSite = null;
        newWebSite.previousSite = this.currentWebSite;
        this.currentWebSite = newWebSite;
    };

    public String previousSite () {

        if(this.currentWebSite.previousSite == null) return getCurrentSite();
        this.currentWebSite = currentWebSite.previousSite;
        System.out.println();
        return getCurrentSite();
    }

    public String forwardSite () {
        if(this.currentWebSite.nextSite == null) return getCurrentSite();
        this.currentWebSite = currentWebSite.nextSite;

        return getCurrentSite();
    }

    public String getSite (ListNode<String> node) {
        return node.value.toString();
    }
    public String getCurrentSite () {return currentWebSite.value.toString();}

    private class ListNode<String> {
        public String value;
        public ListNode<String> nextSite;
        public ListNode<String> previousSite;

        public ListNode() { }
        public ListNode(String site) {
            this.value = site;
        }
    }
}
