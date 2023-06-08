package ma.payment.dao;

import ma.payment.bean.Payeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayeurDao extends JpaRepository<Payeur, Integer> {
    // Add custom query methods if needed
}
