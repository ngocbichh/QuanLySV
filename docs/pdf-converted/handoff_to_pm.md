# Handoff to PM — Document to Markdown (Ingestion Step)

## Status: BLOCKED — no input document provided

## Input source used
- **Attached / context files:** none — no "Context Files" block and no file paths were present in the prompt.
- **User-provided folder:** none — the seed text contained only "## Main"; no folder path was named.
- **Upload directory** (`/tmp/vibeflow/user/`): **empty**.
- **Workspace** (`/workspace`): a Gradle/Java project only; no RFP or office documents present.

Resolution followed the ingestion priority order:
1. Explicit file paths → absent
2. User-provided folder → absent
3. **Neither → STOP and report** (this case)

## Generated Markdown files
- **None.** No source document could be identified, so no conversions were performed.

## Content fidelity flags
- N/A (no content processed).

## Skipped / needing manual conversion
- N/A.

## Final Report Table

| File | Type | Status | Output Path | Pages/Slides/Sheets | Rendered Images | Notes |
|---|---|---|---|---|---|---|
| — | — | **BLOCKED** — no input provided | — | — | — | No source document was attached or referenced. See "Action required" below. |

## Action required to unblock
The upstream orchestrator / user must provide the RFP source in one of two ways:
1. **Attach the RFP document(s)** (PDF, Word .docx/.doc, Excel .xlsx/.xls, PowerPoint .pptx/.ppt, or text) as context/uploaded files; **or**
2. **Give the path to a folder** containing the RFP documents.

Once a source is provided, the Document-to-Markdown step can run the matching skill
(pdf / docx / xlsx / pptx) per file, handle figures (Mermaid or PNG rasterization),
and emit `docs/pdf-converted/{original-name}.md` plus this handoff.