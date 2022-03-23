package com.example.demo.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	TimeService timeService;
	@Autowired
	UserRepository userRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
//	public Page<Product> getAllProductByCategogy(long category_id,int page){
//        return productRepository.findAllByTopicAndIsdeletedAndIsapproved(topic_id,false,true,PageRequest.of(page-1, 5));
//    }
//    public Page<Post> getAllPost(int page){
//        return postRepo.findAllByIsdeletedAndIsapproved(false,true,PageRequest.of(page-1, 5));
//    }
//    public Page<Post> getAllPostNotApproved(int page){
//        return postRepo.findAllByIsdeletedAndIsapproved(false,false,PageRequest.of(page-1, 5));
//    }
//    public Page<Post> getAllYourPostWaitingApproved(long acc_id,int page){
//        return postRepo.findAllByCreatedaccAndIsdeletedAndIsapproved(acc_id,false,false,PageRequest.of(page-1, 5));
//    }
//    public ResponseEntity<Response> createNewPost(long topic_id,long acc_id,Post newPost){
//        Optional<User> foundAcc=accountRepo.findById(acc_id);
//        Optional<Topic> foundTopic=topicRepo.findById(topic_id);
//        newPost.setCreated_acc(foundAcc.get());
//        newPost.setTopic(foundTopic.get());
//        newPost.setCreated_at(timeService.getCurrentTimestamp());
//        foundTopic.map(tp->{
//            tp.setAmountTopic(tp.getAmountTopic()+1);
//            return topicRepo.save(tp);
//        });
//        return  ResponseEntity.status(HttpStatus.OK).body(new Response("OK","Added",postRepo.save(newPost)));
//    }
//    public ResponseEntity<Response> approvePost(long acc_id,long post_id){
//        Optional<User>foundAcc=accountRepo.findById(acc_id);
//        postRepo.findById(post_id).map(p->{
//            p.setIsapproved(true);
//            p.setApproved_acc(foundAcc.get());
//            p.setApproved_at(timeService.getCurrentTimestamp());
//            return postRepo.save(p);
//        });
//        return ResponseEntity.status(HttpStatus.OK).body(new Response("OK","Approved",""));
//    }
//    public ResponseEntity<Response> editPost(long post_id,long updated_acc,Post updatedPost){
//        Optional<User> foundAcc=accountRepo.findById(updated_acc);
//        postRepo.findById(post_id).map(p->{
//            if(updatedPost.getTitle()!=null)
//            p.setTitle(updatedPost.getTitle());
//            if(updatedPost.getContent()!=null)
//            p.setContent(updatedPost.getContent());
//            p.setUpdated_acc(foundAcc.get());
//            p.setUpdated_at(timeService.getCurrentTimestamp());
//            return postRepo.save(p);
//        });
//        return ResponseEntity.status(HttpStatus.OK).body(new Response("OK","Updated",""));
//    }
//    public ResponseEntity<Response> deletePost(long post_id,long deleted_acc){
//        Optional<User> foundAcc=accountRepo.findById(deleted_acc);
//        postRepo.findById(post_id).map(p->{
//            p.setDeleted_acc(foundAcc.get());
//            p.setIsdeleted(true);
//            p.setDeleted_at(timeService.getCurrentTimestamp());
//            topicRepo.findById(p.getTopic().getId()).map(tp->{
//                tp.setAmountTopic(tp.getAmountTopic()-1);
//                return topicRepo.save(tp);
//            });
//            return postRepo.save(p);
//        });
//        commentService.deleteCommentWhenDeletePost(post_id, deleted_acc);
//        return ResponseEntity.status(HttpStatus.OK).body(new Response("OK","Deleted",""));
//    }
//    public ResponseEntity<Response> deletePostWhenDeleteTopic(Long topic_id,long deleted_acc){
//        Optional<Topic> foundTopic=topicRepo.findById(topic_id);
//        List<Post> found=postRepo.findAllByTopic(foundTopic.get());
//        Optional<User> foundAcc=accountRepo.findById(deleted_acc);
//        Timestamp timeDelete=timeService.getCurrentTimestamp();
//        if(found.size()>0)
//        for(Post p:found){
//            p.setDeleted_acc(foundAcc.get());
//            p.setDeleted_at(timeDelete);
//            p.setIsdeleted(true);
//            postRepo.save(p);
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(new Response("OK","Deleted",""));
//    }
	// create Product rest api
//	public ResponseEntity<Response> createProduct(long created_acc,Product product){
//		Optional <User>foundAcc=accountRepo.findById(created_acc);
//        newTopic.setCreated_acc(foundAcc.get());
//        newTopic.setCreated_at(timeService.getCurrentTimestamp());
//        return ResponseEntity.status(HttpStatus.OK).body(new Response("OK","Added",topicRepo.save(newTopic)));
//    }
		
	public Product createProdct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	
	// get product by id rest api
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		Product employee = productRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exits with id: " + id));
		return ResponseEntity.ok(employee);	
	}
	
	// update product rest api
		
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
		java.util.Date jDate= new java.util.Date();
		long currentTime=jDate.getTime();
		
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		product.setName(productDetails.getName());
		product.setQuantity(productDetails.getQuantity());
		product.setPrice(productDetails.getPrice());
		product.setImage(productDetails.getImage());
		product.setStatus(productDetails.getStatus());
		product.setUpdateduser(productDetails.getUpdateduser());
		product.setUpdatedat(new Timestamp(currentTime) );
		
		Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	// delete employee rest api
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	

}
