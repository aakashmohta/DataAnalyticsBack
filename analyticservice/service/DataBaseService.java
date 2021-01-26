package com.example.analyticservice.service;

import com.example.analyticservice.dto.TimeDTO;
import com.example.analyticservice.entity.DataBase;
import com.example.analyticservice.entity.GraphList;
import com.example.analyticservice.repository.DataBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataBaseService {
    @Autowired
    DataBaseRepository dataBaseRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public DataBase save(DataBase dataBase){
        return dataBaseRepository.save(dataBase);
    }

    public DataBase findById(String id){
        return dataBaseRepository.findById(id).get();
    }

    public  List<GraphList> findByPageViews(TimeDTO timeDTO){

        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();
        Query query=new Query(Criteria.where("type").is("profile"));
        query.addCriteria(Criteria.where("platform").is("pagebook"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphLists=new ArrayList<>();
        List<DataBase> iterable=mongoTemplate.find(query,DataBase.class);
        for (DataBase database:iterable)
        {
            graphLists.add(new GraphList(database.getId(),database.getViews()));
        }
        return graphLists;
    }

    public  List<GraphList> findByQuoraViews(TimeDTO timeDTO){

        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();

        Query query=new Query(Criteria.where("type").is("profile"));
        query.addCriteria(Criteria.where("platform").is("quora"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphLists=new ArrayList<>();
        List<DataBase> iterable=mongoTemplate.find(query,DataBase.class);
        for (DataBase database:iterable)
        {
            graphLists.add(new GraphList(database.getId(),database.getViews()));
        }
        return graphLists;
    }

    public List<GraphList> findByPbPostLikes(TimeDTO timeDTO){
        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();
        Query query=new Query(Criteria.where("type").is("post"));
        query.addCriteria(Criteria.where("platform").is("pagebook"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getLikes()));
        }
        return graphList;
    }

    public List<GraphList> findByPbPostDisLikes(TimeDTO timeDTO){
        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();
        Query query=new Query(Criteria.where("type").is("post"));
        query.addCriteria(Criteria.where("platform").is("pagebook"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getDislikes()));
        }
        return graphList;
    }


    public List<GraphList> findByImageLikes(TimeDTO timeDTO){
        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();
        Query query=new Query(Criteria.where("type").is("image"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getLikes()));
        }
        return graphList;
    }

    public List<GraphList> findByImageDisLikes(TimeDTO timeDTO){
        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();
        Query query=new Query(Criteria.where("type").is("image"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getDislikes()));
        }
        return graphList;
    }

    public List<GraphList> findByVideoLikes(TimeDTO timeDTO){
        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();
        Query query=new Query(Criteria.where("type").is("video"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getLikes()));
        }
        return graphList;
    }

    public List<GraphList> findByVideoDisLikes(LocalDateTime dateStart, LocalDateTime dateEnd){
        Query query=new Query(Criteria.where("type").is("video"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getDislikes()));
        }
        return graphList;
    }

    public List<GraphList> findByQuoraComments(TimeDTO timeDTO){
        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();
        Query query=new Query(Criteria.where("type").is("quorapost"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getComments()));
        }
        return graphList;
    }

    public List<GraphList> findByPbComments(TimeDTO timeDTO){
        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();
        Query query=new Query(Criteria.where("type").is("post"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getComments()));
        }
        return graphList;
    }

    public List<GraphList> findByQuoraLikes(TimeDTO timeDTO){
        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();
        Query query=new Query(Criteria.where("type").is("quorapost"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getLikes()));
        }
        return graphList;
    }

    public List<GraphList> findByQuoraDislikes(LocalDateTime dateStart, LocalDateTime dateEnd){
        Query query=new Query(Criteria.where("type").is("quorapost"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getDislikes()));
        }
        return graphList;
    }


    public List<GraphList> findByPopularQuoraPost(LocalDateTime dateStart, LocalDateTime dateEnd){
        Query query=new Query().addCriteria(Criteria.where("type").is("quoraPost")).with(Sort.by(Sort.Direction.DESC,"comments"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getComments()));
        }
        return graphList;
    }


    public List<GraphList> findByPopularImage(LocalDateTime dateStart, LocalDateTime dateEnd){
        Query query=new Query().addCriteria(Criteria.where("type").is("image")).with(Sort.by(Sort.Direction.DESC,"likes"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getLikes()));
        }
        return graphList;
    }

    public List<GraphList> findByPopularVideo(LocalDateTime dateStart, LocalDateTime dateEnd){
        Query query=new Query().addCriteria(Criteria.where("type").is("video")).with(Sort.by(Sort.Direction.DESC,"likes"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<GraphList> graphList=new ArrayList<>();
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            graphList.add(new GraphList(dataBase.getId(),dataBase.getLikes()));
        }
        return graphList;
    }

    public List<GraphList> mostPopularCategory(TimeDTO timeDTO){
        LocalDateTime dateStart, dateEnd;
        dateStart=timeDTO.getDateStartDTO();
        dateEnd=timeDTO.getDateEndDTO();
        int bollywood=0,science=0,technology=0,maths=0,sports=0;
        List<GraphList> graphList=new ArrayList<>();

        Query query=new Query().addCriteria(Criteria.where("category").is("bollywood"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        List<DataBase> dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            bollywood+=dataBase.getLikes();
        }
        graphList.add(new GraphList("Bollowood",bollywood));

        query=new Query().addCriteria(Criteria.where("category").is("science"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            science+=dataBase.getLikes();
        }
        graphList.add(new GraphList("Science",science));

        query=new Query().addCriteria(Criteria.where("category").is("technology"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            science+=dataBase.getLikes();
        }
        graphList.add(new GraphList("Technology",science));

        query=new Query().addCriteria(Criteria.where("category").is("sports"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            science+=dataBase.getLikes();
        }
        graphList.add(new GraphList("Sports",science));

        query=new Query().addCriteria(Criteria.where("category").is("maths"));
        query.addCriteria(Criteria.where("time").gte(dateStart).lte(dateEnd));
        dataBaseList=mongoTemplate.find(query,DataBase.class);
        for(DataBase dataBase:dataBaseList){
            science+=dataBase.getLikes();
        }
        graphList.add(new GraphList("Maths",science));

        return graphList;
    }
}
