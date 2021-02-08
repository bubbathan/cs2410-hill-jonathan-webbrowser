package com.bubsstuff.webbrowser;

import java.util.List;

public class HistoryList {
    private ListNode<String> head = new ListNode<>();
    private int size;

    public HistoryList() {
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

    public String previousSite (String site) {
        ListNode<String> current = head.next;
        ListNode<String> previous = head;

        if(current.previous == null) return getSite(current);

        while (site.compareTo(current.value.toString()) != 0) {
            previous = current;
            current = current.next;
        }
        return getSite(previous);
    }

    public void forwardSite () { }

    public int getHistorySize () {
        return size;
    }

    public String getSite (ListNode<String> node) {
        return node.value.toString();
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
