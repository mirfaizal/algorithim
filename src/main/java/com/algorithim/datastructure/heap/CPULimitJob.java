package com.algorithim.datastructure.heap;

/*
Given a set of jobs array and max number of cpus, where each job object contains 3 props {starttime,duration,numberofCpusNeeded},
write a function which
returns true if the jobs can be executed with the given max cpus else return false even if one job can't be executed?
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CPULimitJob {
    public static void main(String[] args){
        //jobs = [(1, 3, 2), (2, 3, 1), (5, 3, 1)]
        Job job1 = new Job(1, 3, 2);
        Job job2 = new Job(2, 3, 4);
        Job job3 = new Job(5, 8, 1);
        List<Job> jobs = Arrays.asList(job1, job2, job3);
        int total_num_cups = 5;
        boolean executed_all = canExecutedAll(jobs, total_num_cups);
        System.out.println("Executed all ? "+executed_all);
    }

    static class Job{
        int startTime;
        int endTime;
        int num_cup_required;
        public Job(int startTime, int endTime, int num_cup_required){
            this.startTime = startTime;
            this.endTime = endTime;
            this.num_cup_required = num_cup_required;
        }
    }

    private static boolean canExecutedAll(List<Job> jobs, int total_num_cups) {
        Map<Integer, List<Integer>> endTime_map = new HashMap<>();
        Map<Integer, List<Integer>> startTime_map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int index = 0;
        for(Job job : jobs){
            int startTime = job.startTime;
            int endTime = job.endTime + startTime;
            List list = endTime_map.getOrDefault(endTime, new ArrayList<>());
            list.add(index);
            endTime_map.put(endTime, list);
            list = startTime_map.getOrDefault(startTime, new ArrayList<>());
            list.add(index);
            startTime_map.put(startTime, list);
            index++;

            min = Math.min(startTime, min);
            max = Math.max(max, endTime);
        }
        int cur_num_cups = 0;
        for(int time = min; time <= max; time++){
            if(startTime_map.containsKey(time)){
                List<Integer> list = startTime_map.get(time);
                for(int i : list){
                    cur_num_cups += jobs.get(i).num_cup_required;
                }
            }
            if(endTime_map.containsKey(time)){
                List<Integer> list = endTime_map.get(time);
                for(int i : list){
                    cur_num_cups -= jobs.get(i).num_cup_required;
                }
            }
            if(total_num_cups < cur_num_cups)
                return false;
        }
        return true;
    }

}