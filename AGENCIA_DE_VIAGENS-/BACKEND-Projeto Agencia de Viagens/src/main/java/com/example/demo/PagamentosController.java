package com.example.demo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class pagamentosController {
@Autowired
private pagamentosRepository pagamentosRepository;

//Pegar todos os pagamentos
@GetMapping("/pagamentos")
public List<pagamentos> getAllpagamentos() {
return pagamentosRepository.findAll();
}
//Pegar um pagamentos usando seu ID
@GetMapping("/pagamentos/{id}")
public ResponseEntity<pagamentos> getpagamentosById(@PathVariable Long id) {
	pagamentos pagamentos = pagamentosRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("pagamentos nao existe com o id : " + id));
return ResponseEntity.ok(pagamentos);
}
//Criar um novo pagamentos
@PostMapping("/pagamentos")
public pagamentos createpagamentos(@RequestBody pagamentos pagamentos) {
return pagamentosRepository.save(pagamentos);
}
//Alterar  pagamentos
@PutMapping("/pagamentos/{id}")
public ResponseEntity<pagamentos> updatepagamentos(@PathVariable Long id, @RequestBody pagamentos
		pagamentosDetails) {
	pagamentos pagamentos = pagamentosRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("pagamentos nao existe com id :" + id));
	pagamentos.setPrimeiroNome(pagamentosDetails.getPrimeiroNome());
	pagamentos.setUltimoNome(pagamentosDetails.getUltimoNome());
	pagamentos.setEmailId(pagamentosDetails.getEmailId());
	pagamentos updatedpagamentos = fpagamentosRepository.save(pagamentos);
return ResponseEntity.ok(updatedpagamentos);
}
//Deletar um dos pagamentos
@DeleteMapping("/pagamentos/{id}")
public ResponseEntity<Map<String, Boolean>> deletepagamentos (@PathVariable Long id) {
	pagamentos pagamentos = pagamentosRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("Funcionario nao existe com id :" + id));
	pagamentosRepository.delete(pagamentos);
Map<String, Boolean> response = new HashMap<>();
response.put("deletado", Boolean.TRUE);
return ResponseEntity.ok(response);
}
}