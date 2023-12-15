package com.greedy.hellospring.repository;

import com.greedy.hellospring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    /**
     * JPA의 장점
     * 저장하고 ,조회 update , delete는 SQL을 작성할 필요가 없다.
     * findByName이나 목록 조회시 JPQ라는 것을 작성해 주어야 한다.*/

    private final EntityManager em; //JPA는 EntityManager로 동작한다.

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class , id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
       List<Member> result = em.createQuery("select m from member m where m.name = :name" , Member.class)
                .setParameter("name" , name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m" , Member.class)
                .getResultList();
    }
}
