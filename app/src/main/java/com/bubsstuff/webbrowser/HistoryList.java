package com.bubsstuff.webbrowser;

public class HistoryList {
    private ListNode<String> head = new ListNode<>();
    private int size;

    public HistoryList() {
        this.size = 0;
    }

    public void newSite (String site) {
        
    }

    private class ListNode<String> {
        public String value;
        public ListNode<String> next;
        public ListNode<String> previous;

        public ListNode() { }
        public ListNode(String site) {
            this.value = site;
        }
    }
}
