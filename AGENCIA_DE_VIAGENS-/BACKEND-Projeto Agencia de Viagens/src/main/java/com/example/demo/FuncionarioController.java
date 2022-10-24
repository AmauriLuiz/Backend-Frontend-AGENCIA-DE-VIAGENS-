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
public class FuncionarioController {
@Autowired
private FuncionarioRepository funcionarioRepository;
//Pegar todos os funcionarios
@GetMapping("/funcionarios")
public List<Funcionario> getAllFuncionarios() {
return funcionarioRepository.findAll();
}
//Pegar um funcionario usando seu ID
@GetMapping("/funcionarios/{id}")
public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("Funcionario nao existe com o id : " + id));
return ResponseEntity.ok(funcionario);
}
//Criar um novo funcionario
@PostMapping("/funcionarios")
public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
return funcionarioRepository.save(funcionario);
}
//Alterar um funcionario
@PutMapping("/funcionarios/{id}")
public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario
funcionarioDetails) {
Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("Funcionario nao existe com id :" + id));
funcionario.setPrimeiroNome(funcionarioDetails.getPrimeiroNome());
funcionario.setUltimoNome(funcionarioDetails.getUltimoNome());
funcionario.setEmailId(funcionarioDetails.getEmailId());
Funcionario updatedFuncionario = funcionarioRepository.save(funcionario);
return ResponseEntity.ok(updatedFuncionario);
}
//Deletar um funcionario
@DeleteMapping("/funcionarios/{id}")
public ResponseEntity<Map<String, Boolean>> deleteFuncionario (@PathVariable Long id) {
Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("Funcionario nao existe com id :" + id));
funcionarioRepository.delete(funcionario);
Map<String, Boolean> response = new HashMap<>();
response.put("deletado", Boolean.TRUE);
return ResponseEntity.ok(response);
}
}