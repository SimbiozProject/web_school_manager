package com.example.web_school_manager.dao.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyJpaRepository<T, ID> {
    default List<T> findAll() {
        return null;
    }

    default List<T> findAll(Sort var1){
        return null;
    }

    default List<T> findAllById(Iterable<ID> var1){
        return null;
    }

    default <S extends T> List<S> saveAll(Iterable<S> var1){
        return null;
    }

    default void flush(){

    }

    default <S extends T> S saveAndFlush(S var1){
        return null;
    }

    default  <S extends T> List<S> saveAllAndFlush(Iterable<S> var1){
        return null;
    }

    /**
     * @deprecated
     */
    @Deprecated
    default void deleteInBatch(Iterable<T> entities) {
        this.deleteAllInBatch(entities);
    }

    default void deleteAllInBatch(Iterable<T> var1){

    }

    default void deleteAllByIdInBatch(Iterable<ID> var1){

    }
    default void deleteAllInBatch(){

    }

    /**
     * @deprecated
     */
    @Deprecated
    default T getOne(ID var1){
        return null;
    }

    default T getById(ID var1){
        return null;
    }

    default <S extends T> List<S> findAll(Example<S> var1){
        return null;
    }

    default <S extends T> List<S> findAll(Example<S> var1, Sort var2){
        return null;
    }

    default Page<T> findAll(Pageable var1){
        return null;
    }

    default <S extends T> S save(S var1){
        return null;
    }


    default Optional<T> findById(ID var1){
        return null;
    }

    default Boolean existsById(ID var1){
        return null;
    }


    default Long count(){
        return null;
    }

    default void deleteById(ID var1){

    }

    default void delete(T var1){

    }

    default void deleteAllById(Iterable<? extends ID> var1){

    }

    default void deleteAll(Iterable<? extends T> var1){

    }

    default void deleteAll(){

    }
}