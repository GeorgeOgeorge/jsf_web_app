package functional.dao;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import dao.OccupationDao;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;

import models.Occupation;

@NoArgsConstructor
@Data
public class OccupationDaoTest {

    private OccupationDao occupationDao ;
    private List<Occupation> occupations = Arrays.asList(
            new Occupation("devFront"),
            new Occupation("devBack"),
            new Occupation("devFullstack"),
            new Occupation("SoftEng"),
            new Occupation("Manager")
    );

    @Before
    public void BeforeEach() {
        occupationDao = new OccupationDao();
    }

    //test insert
    @Test
    public void testA() {
        this.occupations.forEach(o -> this.occupationDao.insert(o));
    }

    // test Find
    @Test
    public void testB() {
        Occupation occupation = this.occupations.get(0);
        occupation.setId(56L);
        assertTrue(occupation.equals(this.occupationDao.find(occupation.getId())));
    }

    // test List
    @Test
    public void testC() {
        System.out.println(this.occupationDao.list());
    }


    //test Update
    @Test
    public void testD() {
        Occupation occupationTest = new Occupation(3L, "NetworkManager", true);
        assertTrue("update", occupationTest.equals(this.occupationDao.update(occupationTest)));
    }

    //test delete
    @Test
    public void testE() {
        this.occupationDao.remove(this.occupations.get(0).getId());
    }


}