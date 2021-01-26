package com.example.analyticservice.service;

import com.example.analyticservice.entity.GraphList;
import com.example.analyticservice.entity.User;
import com.example.analyticservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public User save(User user){
        return userRepository.save(user);
    }

    public User findById(String id){
        return userRepository.findById(id).get();
    }

    public List<GraphList> findByFollowersPb(){
        List<User> userList=userRepository.findAll();
        List<GraphList> graphList=new ArrayList<>();
        for(User user:userList){
            graphList.add(new GraphList(user.getUserId(),user.getFollowersPb()));
        }
        return graphList;
    }

    public List<GraphList> findByFollowersQuora(){
        List<User> userList=userRepository.findAll();
        List<GraphList> graphList=new ArrayList<>();
        for(User user:userList){
            graphList.add(new GraphList(user.getUserId(),user.getFollowersQuora()));
        }
        return graphList;
    }

    public List<GraphList> findByPopularPbUser(){
        Query query=new Query().with(Sort.by(Sort.Direction.DESC,"followersPb"));
        List<GraphList> graphList=new ArrayList<>();
        List<User> userList=mongoTemplate.find(query,User.class);
        for(User user:userList){
            graphList.add(new GraphList(user.getUserId(),user.getFollowersPb()));
        }
        return graphList;
    }

    public List<GraphList> findByPopularQuoraUser(){
        Query query=new Query().with(Sort.by(Sort.Direction.DESC,"followersQuora"));
        List<GraphList> graphList=new ArrayList<>();
        List<User> userList=mongoTemplate.find(query,User.class);
        for(User user:userList){
            graphList.add(new GraphList(user.getUserId(),user.getFollowersQuora()));
        }
        return graphList;
    }

//    public int getActiveUser(){
//        List<User> list=new ArrayList<>();
//        Query query=new Query(Criteria.where("active").is(true));
//        Iterable<User> iterable=mongoTemplate.find(query,User.class);
//        iterable.forEach(list::add);
//        return list.size();
//    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public String findUserCategory(String userId){
        User user=userRepository.findById(userId).get();
        int[] category=user.getCategories();
        int position=0;
        for(int i=1;i<5;i++){
            if(category[i]>category[position])
                position=i;
        }
        if(position==0)
            return "technology";
        else if(position==1)
            return "science";
        else if(position==2)
            return "bollywood";
        else if(position==3)
            return "sports";
        else
            return "maths";
    }
}
