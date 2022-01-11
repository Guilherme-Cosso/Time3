package com.grupo3.app.Services;

import com.grupo3.app.Dto.LivroDto;
import com.grupo3.app.Dto.LivroDtoViculado;
import com.grupo3.app.Dto.LivroFormDto;
import com.grupo3.app.Dto.VincularLivroUserDto;
import com.grupo3.app.Entity.Livro;
import com.grupo3.app.Entity.User;
import com.grupo3.app.Repository.LivroRepository;
import com.grupo3.app.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroServiceImple implements LivroService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public LivroDto save(LivroFormDto body) {
		Livro livro = modelMapper.map(body, Livro.class);
		Livro livroSave = this.livroRepository.save(livro);
		return modelMapper.map(livroSave, LivroDto.class);
	}

	@Override
	public LivroDto getLivro(Long id) {
		Livro livro = this.livroRepository.getOne(id);
		return modelMapper.map(livro, LivroDto.class);
	}

	@Override
	public List<LivroDto> getLivros() {
		List<Livro> list = this.livroRepository.findAll();
		return list.stream().map(pa -> modelMapper.map(pa, LivroDto.class)).collect(Collectors.toList());
	}

	@Override
	public LivroDto updateLivro(Long id, LivroFormDto body) {
		Livro livro = livroRepository.getOne(id);
		livro.setName(body.getName());
		livro.setAutor(body.getAutor());
		livro.setEditora(body.getEditora());
		livro.setDescricao(body.getDescricao());
		livro.setGenero(body.getGenero());
		livro.setDatapublicacao(body.getDatapublicacao());
		return modelMapper.map(livro, LivroDto.class);
	}

	@Override
	public void deleteLivro(Long id) {
		livroRepository.deleteById(id);
	}

	@Override
	public LivroDtoViculado livroUser(VincularLivroUserDto livroUserDto) {
		Optional<User> user = userRepository.findById(livroUserDto.getIdUser());
		Optional<Livro> livro = livroRepository.findById(livroUserDto.getIdLivro());
		if (user.isPresent() && livro.isPresent()) {
			Livro livroSave = livroRepository.getOne(livroUserDto.getIdLivro());
			livroSave.setUser(user.get());
			return modelMapper.map(livroSave, LivroDtoViculado.class);
		} else {
			return null;
		}
	}

	@Override
	public List<LivroDto> livrosAssociados(Long id) {
		Optional<User> user = userRepository.findById(id);
		List<Livro> livros = livroRepository.findByUser(user.get());
		return livros.stream().map(pa -> modelMapper.map(pa, LivroDto.class)).collect(Collectors.toList());
	}

	@Override
	public LivroDto deletLivroUsuario(Long id, Long ids) {
		Optional<User> user = userRepository.findById(3L);
		Optional<Livro> livro = livroRepository.findById(1L);
		if (user.isPresent() && livro.isPresent()) {
			Livro livroSave = livroRepository.getOne(ids);
			livroSave.setUser(null);
			return modelMapper.map(livroSave, LivroDto.class);
		} else {
			return null;
		}
	}

	@Override
	public List<LivroDto> livrosDisponivies() {
		List<Livro> livros = livroRepository.findByUser(null);
		return livros.stream().map(pa -> modelMapper.map(pa, LivroDto.class)).collect(Collectors.toList());
	}

	// tentativa ordenacao e filtro
	@Override
	public List<LivroDto> find(String sort) {

		List<Livro> livros = this.livroRepository.findAll();

		if (!(sort == null)) {
			if (sort.equals("name")) {
				livros.sort(Comparator.comparing(Livro::getName));
			}

		}

		return livros.stream().map(associate -> modelMapper.map(associate, LivroDto.class))
				.collect(Collectors.toList());
	}
	
	//fitro de genero
	@Override
	public List<LivroDto> buscaGenero(String genero) {

		List<Livro> livros = this.livroRepository.findAllByGenero(genero);

		return livros.stream().map(associate -> modelMapper.map(associate, LivroDto.class))
				.collect(Collectors.toList());
	}

}
