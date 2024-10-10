package gosuclass.domain;

import gosuclass.EvaluationApplication;
import gosuclass.domain.AfterClassEvaluate;
import gosuclass.domain.PreClassEvaluate;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Evaluation_table")
@Data
//<<< DDD / Aggregate Root
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer classId;

    private Integer personId;

    private Integer preScore;

    private Integer afterScore;

    @PostPersist
    public void onPostPersist() {
        PreClassEvaluate preClassEvaluate = new PreClassEvaluate(this);
        preClassEvaluate.publishAfterCommit();

        AfterClassEvaluate afterClassEvaluate = new AfterClassEvaluate(this);
        afterClassEvaluate.publishAfterCommit();
    }

    public static EvaluationRepository repository() {
        EvaluationRepository evaluationRepository = EvaluationApplication.applicationContext.getBean(
            EvaluationRepository.class
        );
        return evaluationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startExam(ClassRegistered classRegistered) {
        //implement business logic here:

        /** Example 1:  new item 
        Evaluation evaluation = new Evaluation();
        repository().save(evaluation);

        */

        /** Example 2:  finding and process
        
        repository().findById(classRegistered.get???()).ifPresent(evaluation->{
            
            evaluation // do something
            repository().save(evaluation);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
