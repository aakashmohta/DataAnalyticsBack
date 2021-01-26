package com.example.analyticsteam.controller;

import com.example.analyticsteam.dto.QueryDTO;
import com.example.analyticsteam.dto.TimeDTO;
import com.example.analyticsteam.entity.*;
import com.example.analyticsteam.service.ContentStatusService;
import com.example.analyticsteam.service.DataBaseService;
import com.example.analyticsteam.service.QuizService;
import com.example.analyticsteam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("analytics")
public class AnalyticsController {
    @Autowired
    UserService userService;
    @Autowired
    DataBaseService dataBaseService;
    @Autowired
    QuizService quizService;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    ContentStatusService contentStatusService;

    @PostMapping("/query")
    public void getDTO(@RequestBody QueryDTO queryDTO){
        switch (queryDTO.getChannel_id()){
            case 1://common infra
                if(queryDTO.getAction().equals("register")) {
                    User user = new User();
                    user.setUserId(queryDTO.getUserId());
                    int catUser[] = {0, 0, 0, 0, 0};
                    user.setCategories(catUser);
                    user.setPopularity(0);
                    user.setFollowersPb(0);
                    user.setFollowersQuora(0);
                    user.setViews(0);
                    userService.save(user);
                }
                break;
            case 2://pagebook
                if(queryDTO.getAction().equals("posting")) {
                    DataBase dataBase = new DataBase();
                    dataBase.setCategory(queryDTO.getCategory());
                    dataBase.setPlatform("pagebook");
                    dataBase.setTime(queryDTO.getTime());
                    dataBase.setId(queryDTO.getTypeId());
                    dataBase.setType(queryDTO.getType());
                    dataBase.setComments(0);
                    dataBase.setDislikes(0);
                    dataBase.setLikes(0);
                    dataBase.setSubscribed(0);
                    dataBase.setShares(0);
                    dataBaseService.save(dataBase);

//                    Query query=new Query();
//                    query.addCriteria(Criteria.where("userId").is(queryDTO.getUserId()));
//                    Update update=new Update();
//                    if(queryDTO.getCategory().equals("technology"))
//                    update.inc("categories.$[0]",1);
//                    else if(queryDTO.getCategory().equals("science"))
//                        update.inc("categories.$[1]",1);
//                    else if(queryDTO.getCategory().equals("bollywood"))
//                        update.inc("categories.$[2]",1);
//                    else if(queryDTO.getCategory().equals("sports"))
//                        update.inc("categories.$[3]",1);
//                    else
//                        update.inc("categories.$[4]",1);
//                    mongoTemplate.updateFirst(query,update,User.class);
                    User user=userService.findById(queryDTO.getUserId());
                    int[] cat=user.getCategories();
                    if(queryDTO.getCategory().equals("technology"))
                        cat[0]++;
                    else if(queryDTO.getCategory().equals("science"))
                        cat[1]++;
                    else if(queryDTO.getCategory().equals("bollywood"))
                        cat[2]++;
                    else if(queryDTO.getCategory().equals("sports"))
                        cat[3]++;
                    else
                        cat[4]++;
                    userService.save(user);
                }

                else if(queryDTO.getAction().equals("like")){
                    Query query=new Query();
                    query.addCriteria(Criteria.where("id").is(queryDTO.getTypeId()));
                    Update update=new Update();
                    update.inc("likes",1);
                    mongoTemplate.updateFirst(query,update,DataBase.class);

//                    Query query1=new Query();
//                    query1.addCriteria(Criteria.where("userId").is(queryDTO.getUserId()));
//                    Update update1=new Update();
//                    if(queryDTO.getCategory().equals("technology"))
//                        update1.inc("category.$[0]",1);
//                    else if(queryDTO.getCategory().equals("science"))
//                        update1.inc("category.$[1]",1);
//                    else if(queryDTO.getCategory().equals("bollywood"))
//                        update1.inc("category.$[2]",1);
//                    else if(queryDTO.getCategory().equals("sports"))
//                        update1.inc("category.$[3]",1);
//                    else
//                        update1.inc("category.$[4]",1);
//                    mongoTemplate.updateFirst(query1,update1,User.class);
                    User user=userService.findById(queryDTO.getUserId());
                    int[] cat=user.getCategories();
                    if(queryDTO.getCategory().equals("technology"))
                        cat[0]++;
                    else if(queryDTO.getCategory().equals("science"))
                        cat[1]++;
                    else if(queryDTO.getCategory().equals("bollywood"))
                        cat[2]++;
                    else if(queryDTO.getCategory().equals("sports"))
                        cat[3]++;
                    else
                        cat[4]++;
                    userService.save(user);
                }

                else if(queryDTO.getAction().equals("dislike")){
                    Query query=new Query();
                    query.addCriteria(Criteria.where("id").is(queryDTO.getTypeId()));
                    Update update=new Update();
                    update.inc("dislikes",1);
                    mongoTemplate.updateFirst(query,update,DataBase.class);

//                    Query query1=new Query();
//                    query1.addCriteria(Criteria.where("userId").is(queryDTO.getUserId()));
//                    Update update1=new Update();
//                    if(queryDTO.getCategory().equals("technology"))
//                        update1.inc("category.$[0]",-1);
//                    else if(queryDTO.getCategory().equals("science"))
//                        update1.inc("category.$[1]",-1);
//                    else if(queryDTO.getCategory().equals("bollywood"))
//                        update1.inc("category.$[2]",-1);
//                    else if(queryDTO.getCategory().equals("sports"))
//                        update1.inc("category.$[3]",-1);
//                    else
//                        update1.inc("category.$[4]",-1);
//                    mongoTemplate.updateFirst(query1,update1,User.class);
                    User user=userService.findById(queryDTO.getUserId());
                    int[] cat=user.getCategories();
                    if(queryDTO.getCategory().equals("technology"))
                        cat[0]--;
                    else if(queryDTO.getCategory().equals("science"))
                        cat[1]--;
                    else if(queryDTO.getCategory().equals("bollywood"))
                        cat[2]--;
                    else if(queryDTO.getCategory().equals("sports"))
                        cat[3]--;
                    else
                        cat[4]--;
                    userService.save(user);
                }
                else if(queryDTO.getAction().equals("comment")){
                    Query query=new Query();
                    query.addCriteria(Criteria.where("id").is(queryDTO.getTypeId()));
                    Update update=new Update();
                    update.inc("comments",1);
                    mongoTemplate.updateFirst(query,update,DataBase.class);

//                    Query query1=new Query();
//                    query1.addCriteria(Criteria.where("userId").is(queryDTO.getUserId()));
//                    Update update1=new Update();
//                    if(queryDTO.getCategory().equals("technology"))
//                        update1.inc("category.$[0]",1);
//                    else if(queryDTO.getCategory().equals("science"))
//                        update1.inc("category.$[1]",1);
//                    else if(queryDTO.getCategory().equals("bollywood"))
//                        update1.inc("category.$[2]",1);
//                    else if(queryDTO.getCategory().equals("sports"))
//                        update1.inc("category.$[3]",1);
//                    else
//                        update1.inc("category.$[4]",1);
//                    mongoTemplate.updateFirst(query1,update1,User.class);
                    User user=userService.findById(queryDTO.getUserId());
                    int[] cat=user.getCategories();
                    if(queryDTO.getCategory().equals("technology"))
                        cat[0]++;
                    else if(queryDTO.getCategory().equals("science"))
                        cat[1]++;
                    else if(queryDTO.getCategory().equals("bollywood"))
                        cat[2]++;
                    else if(queryDTO.getCategory().equals("sports"))
                        cat[3]++;
                    else
                        cat[4]++;
                    userService.save(user);
                }

                else if(queryDTO.getAction().equals("share")){
                    Query query=new Query();
                    query.addCriteria(Criteria.where("id").is(queryDTO.getTypeId()));
                    Update update=new Update();
                    update.inc("shares",1);
                    mongoTemplate.updateFirst(query,update,DataBase.class);

//                    Query query1=new Query();
//                    query1.addCriteria(Criteria.where("userId").is(queryDTO.getUserId()));
//                    Update update1=new Update();
//                    if(queryDTO.getCategory().equals("technology"))
//                        update1.inc("category.$[0]",1);
//                    else if(queryDTO.getCategory().equals("science"))
//                        update1.inc("category.$[1]",1);
//                    else if(queryDTO.getCategory().equals("bollywood"))
//                        update1.inc("category.$[2]",1);
//                    else if(queryDTO.getCategory().equals("sports"))
//                        update1.inc("category.$[3]",1);
//                    else
//                        update1.inc("category.$[4]",1);
//                    mongoTemplate.updateFirst(query1,update1,User.class);
                    User user=userService.findById(queryDTO.getUserId());
                    int[] cat=user.getCategories();
                    if(queryDTO.getCategory().equals("technology"))
                        cat[0]++;
                    else if(queryDTO.getCategory().equals("science"))
                        cat[1]++;
                    else if(queryDTO.getCategory().equals("bollywood"))
                        cat[2]++;
                    else if(queryDTO.getCategory().equals("sports"))
                        cat[3]++;
                    else
                        cat[4]++;
                    userService.save(user);
                }

                else if(queryDTO.getAction().equals("view profile")){
                    Query query=new Query();
                    query.addCriteria(Criteria.where("id").is(queryDTO.getUserId()));
                    Update update=new Update();
                    update.inc("views",1);
                    mongoTemplate.updateFirst(query,update,User.class);
                }
                break;

            case 3://quora
                if(queryDTO.getAction().equals("posting")){
                    DataBase dataBase=new DataBase();
                    dataBase.setCategory(queryDTO.getCategory());
                    dataBase.setPlatform("quora");
                    dataBase.setTime(queryDTO.getTime());
                    dataBase.setId(queryDTO.getTypeId());
                    dataBase.setComments(0);
                    dataBase.setDislikes(0);
                    dataBase.setLikes(0);
                    dataBase.setSubscribed(0);
                    dataBase.setShares(0);
                    dataBaseService.save(dataBase);

//                    Query query=new Query();
//                    query.addCriteria(Criteria.where("userId").is(queryDTO.getUserId()));
//                    Update update=new Update();
//                    if(queryDTO.getCategory().equals("technology"))
//                        update.set("category.$[0]","category.$[0]"+1);
//                    else if(queryDTO.getCategory().equals("science"))
//                        update.inc("category.$[1]",1);
//                    else if(queryDTO.getCategory().equals("bollywood"))
//                        update.inc("category.$[2]",1);
//                    else if(queryDTO.getCategory().equals("sports"))
//                        update.inc("category.$[3]",1);
//                    else
//                        update.inc("category.$[4]",1);
//                    mongoTemplate.updateFirst(query,update,User.class);
                    User user=userService.findById(queryDTO.getUserId());
                    int[] cat=user.getCategories();
                    if(queryDTO.getCategory().equals("technology"))
                        cat[0]++;
                    else if(queryDTO.getCategory().equals("science"))
                        cat[1]++;
                    else if(queryDTO.getCategory().equals("bollywood"))
                        cat[2]++;
                    else if(queryDTO.getCategory().equals("sports"))
                        cat[3]++;
                    else
                        cat[4]++;
                    userService.save(user);
                }

                else if(queryDTO.getAction().equals("view profile")){
                    User user=userService.findById(queryDTO.getUserId());
                    user.setViews(user.getViews()+1);
                    userService.save(user);
                }

                else if(queryDTO.getAction().equals("comment")){
                    Query query=new Query();
                    query.addCriteria(Criteria.where("id").is(queryDTO.getTypeId()));
                    Update update=new Update();
                    update.inc("comments",1);
                    mongoTemplate.updateFirst(query,update,DataBase.class);

//                    Query query1=new Query();
//                    query1.addCriteria(Criteria.where("userId").is(queryDTO.getUserId()));
//                    Update update1=new Update();
//                    if(queryDTO.getCategory().equals("technology"))
//                        update1.inc("category.$[0]",1);
//                    else if(queryDTO.getCategory().equals("science"))
//                        update1.inc("category.$[1]",1);
//                    else if(queryDTO.getCategory().equals("bollywood"))
//                        update1.inc("category.$[2]",1);
//                    else if(queryDTO.getCategory().equals("sports"))
//                        update1.inc("category.$[3]",1);
//                    else
//                        update1.inc("category.$[4]",1);
//                    mongoTemplate.updateFirst(query1,update1,User.class);
                    User user=userService.findById(queryDTO.getUserId());
                    int[] cat=user.getCategories();
                    if(queryDTO.getCategory().equals("technology"))
                        cat[0]++;
                    else if(queryDTO.getCategory().equals("science"))
                        cat[1]++;
                    else if(queryDTO.getCategory().equals("bollywood"))
                        cat[2]++;
                    else if(queryDTO.getCategory().equals("sports"))
                        cat[3]++;
                    else
                        cat[4]++;
                    userService.save(user);
                }

                else if(queryDTO.getAction().equals("dislike")){
                    Query query=new Query();
                    query.addCriteria(Criteria.where("id").is(queryDTO.getTypeId()));
                    Update update=new Update();
                    update.inc("dislikes",1);
                    mongoTemplate.updateFirst(query,update,DataBase.class);

//                    Query query1=new Query();
//                    query1.addCriteria(Criteria.where("userId").is(queryDTO.getUserId()));
//                    Update update1=new Update();
//                    if(queryDTO.getCategory().equals("technology"))
//                        update1.inc("category.$[0]",-1);
//                    else if(queryDTO.getCategory().equals("science"))
//                        update1.inc("category.$[1]",-1);
//                    else if(queryDTO.getCategory().equals("bollywood"))
//                        update1.inc("category.$[2]",-1);
//                    else if(queryDTO.getCategory().equals("sports"))
//                        update1.inc("category.$[3]",-1);
//                    else
//                        update1.inc("category.$[4]",-1);
//                    mongoTemplate.updateFirst(query1,update1,User.class);
                    User user=userService.findById(queryDTO.getUserId());
                    int[] cat=user.getCategories();
                    if(queryDTO.getCategory().equals("technology"))
                        cat[0]--;
                    else if(queryDTO.getCategory().equals("science"))
                        cat[1]--;
                    else if(queryDTO.getCategory().equals("bollywood"))
                        cat[2]--;
                    else if(queryDTO.getCategory().equals("sports"))
                        cat[3]--;
                    else
                        cat[4]--;
                    userService.save(user);
                }

                else if(queryDTO.getAction().equals("like")){
                    Query query=new Query();
                    query.addCriteria(Criteria.where("id").is(queryDTO.getTypeId()));
                    Update update=new Update();
                    update.inc("likes",1);
                    mongoTemplate.updateFirst(query,update,DataBase.class);

//                    Query query1=new Query();
//                    query1.addCriteria(Criteria.where("userId").is(queryDTO.getUserId()));
//                    Update update1=new Update();
//                    if(queryDTO.getCategory().equals("technology"))
//                        update1.inc("category.$[0]",1);
//                    else if(queryDTO.getCategory().equals("science"))
//                        update1.inc("category.$[1]",1);
//                    else if(queryDTO.getCategory().equals("bollywood"))
//                        update1.inc("category.$[2]",1);
//                    else if(queryDTO.getCategory().equals("sports"))
//                        update1.inc("category.$[3]",1);
//                    else
//                        update1.inc("category.$[4]",1);
//                    mongoTemplate.updateFirst(query1,update1,User.class);
                    User user=userService.findById(queryDTO.getUserId());
                    int[] cat=user.getCategories();
                    if(queryDTO.getCategory().equals("technology"))
                        cat[0]++;
                    else if(queryDTO.getCategory().equals("science"))
                        cat[1]++;
                    else if(queryDTO.getCategory().equals("bollywood"))
                        cat[2]++;
                    else if(queryDTO.getCategory().equals("sports"))
                        cat[3]++;
                    else
                        cat[4]++;
                    userService.save(user);
                }
                break;

            case 4://quiz
                Quiz quiz=new Quiz();
                quiz.setQuizId(queryDTO.getTypeId());
                quiz.setWinnerId(queryDTO.getWinnerId());
                quiz.setUsersRegistered(queryDTO.getUsersRegistered());
                quiz.setMostAnsQ(queryDTO.getMostAnsQ());
                quiz.setStartTime(queryDTO.getTime());
                quizService.save(quiz);
                break;
        }
    }


    @PostMapping("/get/{queryId}")
    public List<GraphList> getData(@PathVariable("queryId") int queryId, @RequestBody TimeDTO timeRange){

        switch (queryId){

            case 2:return dataBaseService.findByPageViews(timeRange);

            case 3:return dataBaseService.findByQuoraViews(timeRange);

            case 4:return dataBaseService.findByImageLikes(timeRange);

            case 5: return dataBaseService.findByVideoLikes(timeRange);

            case 6: return dataBaseService.findByPbPostLikes(timeRange);

            case 7: return dataBaseService.findByQuoraLikes(timeRange);

            case 8: return dataBaseService.findByPbPostDisLikes(timeRange);

            case 9: return dataBaseService.findByPbComments(timeRange);

            case 10: return dataBaseService.findByQuoraComments(timeRange);

            case 11: return userService.findByFollowersPb();

            case 12: return userService.findByFollowersQuora();

            case 13:return quizService.mostPopularQuiz(timeRange);

            case 14:return dataBaseService.mostPopularCategory(timeRange);

            case 15:return quizService.quizRunning(timeRange);

            case 16: return quizService.quizRunning(timeRange);

            case 17:
        }
        return null;
    }



    @GetMapping("/ad/{userId}")
    public String getAd(@PathVariable("userId") String userId){
        return userService.findUserCategory(userId);
    }
}
