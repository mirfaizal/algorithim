package com.algorithim.datastructure.misc;

import java.util.*;

class SubDomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String domain = cpdomains[i];
            StringTokenizer st = new StringTokenizer(domain, " ");
            Integer value = 0;
            String key = "";
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                try {
                    value = Integer.parseInt(token);
                } catch (NumberFormatException e) {
                    key = token;
                    Integer valueExistInMap = map.get(key);
                    if (valueExistInMap == null) {
                        map.put(key, value);
                    } else {
                        map.put(key, value + valueExistInMap);
                    }
                    for (int j = 0; j < key.length(); j++) {
                        if (key.charAt(j) == '.') {
                            valueExistInMap = map.get(key.substring(j + 1));
                            if (valueExistInMap == null) {
                                map.put(key.substring(j + 1), value);
                            } else {
                                map.put(key.substring(j + 1), value + valueExistInMap);
                            }
                        }
                    }
                }
            }
        }
        List<String> newList = new ArrayList();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            newList.add(sb.toString());
        }
        return newList;
    }
}