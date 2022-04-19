package io.kadev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kadev.entities.ArchiveDocumentResponse;
import io.kadev.entities.ArchiveLaptopResponse;
import io.kadev.services.LibraryServiceImpl;

@RestController
@RequestMapping("/archive")
public class ArchiveController {
	@Autowired
	private LibraryServiceImpl lsi;
	
	@GetMapping("/documents")
	public List<ArchiveDocumentResponse> getDocumentsArchive(){
		return lsi.getDocArchives();
	}
	@GetMapping("/laptops")
	public List<ArchiveLaptopResponse> getLaptopsArchive(){
		return lsi.getLapArchives();
	}
}
