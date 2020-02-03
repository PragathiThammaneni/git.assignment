package git.assignment;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

final public class CommitObject {
	
	
	final private String commitMessage;
	
	// Storing integer hashcode pointing to Tree Object.
	final private Integer Tree;
	
	final private Date commitDate;
	
	final private Date authoringDate;
	
	final private PersonIdentity author;
	
	final private PersonIdentity commiter;
	
	// Storing the list of parent objects hash codes.
	final private List<Integer> parents;

	public String getCommitMessage() {
		return commitMessage;
	}

	public Integer getTree() {
		return Tree;
	}

	public PersonIdentity getAuthor() {
		return author;
	}

	public PersonIdentity getCommiter() {
		return commiter;
	}

	public List<Integer> getParents() {
		//Performing a deep copy before returning the parents hash codes
		return new LinkedList<Integer>(parents);
	}
	
	//Performing Deepcopy of date objects
	public Date getCommitDate() {
		return (Date) commitDate.clone();
	}	

	public Date getAuthoringDate() {
		return (Date) authoringDate.clone();
	}

	public CommitObject(String commitMessage, Integer tree, Date commitDate, Date authoringDate, PersonIdentity author,
			PersonIdentity commiter, List<Integer> parents) {
		super();
		this.commitMessage = commitMessage;
		Tree = tree;
		this.commitDate = commitDate;
		this.authoringDate = authoringDate;
		this.author = author;
		this.commiter = commiter;
		this.parents = parents;
	}


	@Override
	public String toString() {
		return "CommitObject [commitMessage=" + commitMessage + ", Tree=" + Tree + ", commitDate=" + commitDate
				+ ", authoringDate=" + authoringDate + ", author=" + author.getName() + ", Author Email:"  + author.getEmailAddress()+ ", commiter="
						+ commiter.getName() + ",Commiter Email:"  + commiter.getEmailAddress()+ ", parents="
				+ parents + "]";
	}

	// Generating commit object hash based on its meta data
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Tree == null) ? 0 : Tree);
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((commitDate == null) ? 0 : commitDate.hashCode());
		result = prime * result + ((commitMessage == null) ? 0 : commitMessage.hashCode());
		result = prime * result + ((commiter == null) ? 0 : commiter.hashCode());
		
		// Including all the parent object hash codes
		for(Integer temp: parents)
			result = prime * result + ((temp == null)? 0 : temp);
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommitObject other = (CommitObject) obj;
		if (Tree == null) {
			if (other.Tree != null)
				return false;
		} else if (!Tree.equals(other.Tree))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (commitDate == null) {
			if (other.commitDate != null)
				return false;
		} else if (!commitDate.equals(other.commitDate))
			return false;
		if (commitMessage == null) {
			if (other.commitMessage != null)
				return false;
		} else if (!commitMessage.equals(other.commitMessage))
			return false;
		if (commiter == null) {
			if (other.commiter != null)
				return false;
		} else if (!commiter.equals(other.commiter))
			return false;
		if (parents == null) {
			if (other.parents != null)
				return false;
		} else if (!parents.equals(other.parents))
			return false;
		return true;
	}

	
	
	
	
	
	

}
