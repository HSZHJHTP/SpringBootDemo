package com.ynet.dao.repository;
/**
* @author hansz
* @version 2018年2月10日 下午2:38:28
* @Description 
*/


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ynet.entity.Boy;

/**
 * @author hansz
 * @version 2018年2月27日 下午10:58:15
 * @Description TODO spring data jpa
 */
public interface BoyRepository extends JpaRepository<Boy, Integer> {
	public List<Boy> findByAge(Integer age);


}
