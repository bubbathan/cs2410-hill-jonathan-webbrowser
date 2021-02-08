package com.bubsstuff.webbrowser;

public class HistoryList {
    private ListNode<String> head = new ListNode<>();
    private int size;

    public HistoryList() {
        this.size = 0;
    }

    public void addSite (String site) {
        ListNode<String> newSite = new ListNode<>(site);
        ListNode<String> current = head.next;
        ListNode<String> previous = head;

        while (current != null) {
            previous = current;
            current = current.next;
        }

        previous.next = newSite;
        newSite.next = null;
        size++;
    }

    public void previousSite () { }

    public void forwardSite () { }

    public int getHistorySize () {
        return size;
    }

    public String getSite (ListNode node) {
        
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
