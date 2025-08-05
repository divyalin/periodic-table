package com.divyalin.periodic_table.repository;

import com.divyalin.periodic_table.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * The repository for retrieving elements from the db
 *
 * @author Divyalin
 * @version 1.0
 */
public interface ElementRepository extends JpaRepository<Element, Integer> {

    /**
     * This method returns all elements based on their group number.
     * <p>
     * Since group 1 can match with group 11, group 12 etc, it is matched only with
     * those groups that have a space or comma immediately after the group number.
     * </p>
     *
     * @param groupNumber the group for which elements are to be retrieved
     * @return the list of matching elements
     */
    @Query(value = "SELECT * FROM T_ELEMENT WHERE group_block ~ CONCAT('^', :groupNumber, '[ ,]')", nativeQuery = true)
    List<Element> findByGroupNumber(@Param("groupNumber") String groupNumber);
}
