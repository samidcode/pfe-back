package ma.payment.dao;

import ma.payment.bean.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseDao extends JpaRepository<Classe, Integer> {


}
