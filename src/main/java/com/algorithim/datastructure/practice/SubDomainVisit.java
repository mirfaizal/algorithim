package com.algorithim.datastructure.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
    811. Subdomain Visit Count

    A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com",
    at the next level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com".
    When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

    A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2"
    where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.

    For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited 9001 times.
    Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input.
    You may return the answer in any order.

    Example 1:

    Input: cpdomains = ["9001 discuss.leetcode.com"]
    count = 9001
    domain = discuss.leetcode.com

    HM<domain, count> [9001,discuss.leetcode.com]
                      [9001, leetcode.com]
                      [9001, com]
    Space - O(n)
    Time - O(n*d)

    Output: ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
    Explanation: We only have one website domain: "discuss.leetcode.com".
    As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.

    Example 2:

    Input: cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
    Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
    Explanation: We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times.
    For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 */
public class SubDomainVisit {
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String cpdomain : cpdomains){
            // "9001 discuss.leetcode.com"
            String [] domains = cpdomain.split(" ");
            int frequency = Integer.parseInt(domains[0]);
            String domain = domains[1];
            int currentCount = map.getOrDefault(domain,0);
            map.put(domain, currentCount + frequency);
            for(int i=0;i<domain.length();i++){
                // "9001 discuss.leetcode.com"
                if(domain.charAt(i) == '.') {
                    String subDomain = domain.substring(i+1);
                    int count = map.getOrDefault(subDomain,0);
                    map.put(subDomain, frequency + count);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            StringBuilder sb = new StringBuilder();
            String key = entry.getKey();
            int value = entry.getValue();
            sb.append(value);
            sb.append(" ");
            sb.append(key);
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}
