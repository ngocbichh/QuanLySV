# Working Protocol — RFP Bid Response

> **Version:** 1.0  
> **Owner:** PM (FPT Software)  
> **Date:** 2026-08-05  
> **Applies to:** All roles in this workflow

---

## 1. Purpose

This document defines the working protocol for all roles participating in the RFP bid response workflow. It establishes the rules, conventions, and processes that ensure smooth handoff between roles and consistent output quality.

---

## 2. Workflow Steps

| Step | Role | Output Location | Depends On |
|------|------|----------------|------------|
| 0 | PDF Converter | `docs/00_converted/` | RFP source document |
| 1 | PM (Planning) | `docs/01_planning/` | Step 0 |
| 2a | Solutions Architect | `docs/02_system_architecture/` | Step 1 |
| 2b | Cloud Expert | `docs/03_cloud_infrastructure/` | Step 1 |
| 3 | PM (Review & Proposal) | `docs/04_pm_final/` | Step 2a + 2b |
| 4 | Slide Craft | `slides/` | Step 3 |
| 5a | Backend Engineer | `demo/backend/` | Step 2a (API contract) |
| 5b | Frontend Engineer | `demo/frontend/` | Step 2a (API contract) + Step 3 (demo scope) |

### Parallel Execution Notes

- **Step 2 (Architecture):** SA and Cloud Expert run in parallel. Both read the same RFP content and planning docs. A coordinator reconciles any conflicts.
- **Step 5 (Implementation):** Backend and Frontend run in parallel. Both implement against the **frozen** API contract from Step 2a. A coordinator reconciles integration issues.

---

## 3. Before Starting (Every Role)

Every role MUST complete these steps before beginning work:

1. **Read the handoff note** from the previous step (`handoff_to_[your_role].md`)
2. **Read all RFP content** under `docs/00_converted/`
3. **Read all prior-step outputs** under `docs/` (any `docs/NN_*` folder with a lower number)
4. **Read `AGENTS.md`** at the project root for workflow rules
5. **Initialize todo tool** with your task list

---

## 4. While Working

### 4.1 Task Tracking
- Use the **todo tool** to display and update your task list
- Mark tasks as `in_progress` before starting, `completed` after finishing
- Keep the todo list visible so the PM can track progress

### 4.2 Questions & Clarifications
- Use the **question tool** when something is unclear
- Do NOT assume or guess — ask for clarification
- If the question is about architecture, direct to Solutions Architect
- If the question is about RFP requirements, the PM decides

### 4.3 Output Location
- Save all documentation to the correct `docs/NN_*` folder
- Code demo output goes to `demo/backend/` or `demo/frontend/`
- Slide deck goes to `slides/`
- **Do NOT** place outputs in the wrong folder

### 4.4 Diagrams
- Use **Mermaid** for all diagrams
- Mermaid v11.12.2 compatible syntax only
- Standard arrows: `-->`, `---`, `-.->`, `==>`
- Node labels with special characters: wrap in quotes `A["Label (with parens)"]`
- Every `subgraph` must have a matching `end`
- Do NOT use reserved words (`end`, `graph`, `style`) as bare node IDs
- Verify diagrams render before outputting

### 4.5 Language
- All proposal documents and demo UI must be in **Japanese**
- Internal working documents (planning, architecture) may be in English
- The final proposal (`docs/04_pm_final/proposal.md`) must be entirely in Japanese

---

## 5. At the End of Each Step

### 5.1 Self-Review Checklist

Before creating a handoff, every role MUST self-review:

- [ ] All deliverables saved to the correct folder
- [ ] All diagrams render correctly (Mermaid syntax valid)
- [ ] Document follows the defined template (if applicable)
- [ ] No placeholders or TODO items left unresolved
- [ ] Cross-references to other documents are correct
- [ ] Language is appropriate (Japanese for proposal, English for internal docs)

### 5.2 Handoff Note

Every role MUST create a handoff note before stopping. Format:

```markdown
# Handoff to [Next Role]

## What Was Done
- [List of completed deliverables]

## Key Decisions
- [Key decisions made that the next role needs to know]

## Watch Out For
- [Known issues, limitations, or things to be aware of]

## Pending / Deferred
- [Items not completed, with reason]

## Files Produced
| File | Description |
|------|-------------|
| `path/to/file.md` | Brief description |
```

### 5.3 Done Condition

A step is **COMPLETE** when and only when:
- [ ] All deliverables saved to the correct folder
- [ ] Handoff note created and printed to screen
- [ ] Self-review checklist passed

**Then STOP.** Do not proceed to the next step.

---

## 6. API Contract (Critical Artifact)

The **API contract** produced by the Solutions Architect in Step 2a is the **single source of truth** for the demo implementation.

### Rules:
1. The API contract is **frozen** once Step 2 completes
2. Backend and Frontend implement against the frozen contract
3. Any changes to the API contract during Step 5 require PM approval
4. The API contract must be in OpenAPI/Swagger format
5. The contract must include: endpoints, request/response schemas, authentication, error codes

---

## 7. Quality Standards

### 7.1 Document Quality
- Use clear, professional language
- Follow the defined template for each document type
- Include diagrams where they add clarity
- Cross-reference related documents

### 7.2 Code Quality (Demo)
- Follow the framework's standard conventions
- Include error handling
- Implement Japanese localization for all UI text
- Include sample data that demonstrates the wow moments

### 7.3 Diagram Quality
- All diagrams must be Mermaid (no ASCII art, no images)
- Diagrams must be self-explanatory (labels, legends)
- Architecture diagrams must show boundaries and data flow

---

## 8. Conflict Resolution

When parallel workstreams produce conflicting outputs:

1. **Coordinator** identifies the conflict
2. **PM** makes the final decision based on:
   - RFP requirements (primary)
   - Technical feasibility
   - Timeline impact
3. The decision is documented in the handoff note

---

## 9. Emergency Escalation

If a role is blocked and cannot proceed:

1. Document the blocker in the handoff note
2. Mark the step status as **BLOCKED**
3. The PM decides how to resolve (provide missing info, adjust scope, etc.)

---

*End of Working Protocol*