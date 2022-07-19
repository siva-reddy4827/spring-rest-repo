package com.rlp.project.rlpproject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rlp.project.rlpproject.beans.Topic;

@Service
public class TopicService {

	private List<Topic> listTopic = new ArrayList<>(Arrays.asList(new Topic("spring", "spring framework", "spring framework description"),
			new Topic("java", "core java", "core java framwork"),
			new Topic("java script", "java script", "java script description"),
			new Topic("spring", "spring framework", "spring framework description")));
	
	public List<Topic> getAllTopics(){
		return listTopic;
	}

	public Topic getTopic(String id) {
		return listTopic.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		listTopic.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for(int i=0; i< listTopic.size(); i++) {
			Topic getTopic = listTopic.get(i);
			if(getTopic.getId().equals(id)) {
				listTopic.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		listTopic.removeIf(topic -> topic.getId().equals(id));
	} 
}
